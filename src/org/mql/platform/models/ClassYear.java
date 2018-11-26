package org.mql.platform.models;

import javax.persistence.Embeddable;

/**
 * @author chermehdi
 */
@Embeddable
public class ClassYear {

  private int begin;

  private int end;


  public ClassYear() {

  }

  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String toString() {
    return begin + "/" + end;
  }
}
