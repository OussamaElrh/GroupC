package org.mql.platform.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * @author mehdithe
 */
@XmlType
@XmlEnum
public enum Status {
	@XmlEnumValue("célébataire")
	SINGLE,
	@XmlEnumValue("marié(e)")
	MARRIED
}
