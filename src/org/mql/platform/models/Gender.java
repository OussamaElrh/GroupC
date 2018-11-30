package org.mql.platform.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * @author mehdithe
 */
@XmlType
@XmlEnum
public enum Gender {
  @XmlEnumValue("Homme")
  MALE("Homme"),
  
  @XmlEnumValue("Femme")
  FEMALE("Femme");

  private String representation;

  Gender(String representation) {
    this.representation = representation;
  }

}
