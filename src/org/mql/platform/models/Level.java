package org.mql.platform.models;

/**
 * @author chermehdi
 */
public enum Level {

  M1("Premiere annee"),

  M2("Deuxieme annee"),

  LAUREATE("Lauréat");

  private String representation;

  Level(String representation) {
    this.representation = representation;
  }

  public String getRepresentation() {
    return representation;
  }

  public void setRepresentation(String representation) {
    this.representation = representation;
  }
}
