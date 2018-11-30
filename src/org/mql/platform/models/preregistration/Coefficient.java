package org.mql.platform.models.preregistration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
@XmlRootElement(name="coefficient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coefficient {
	
	private String name;
	
	private double value;
	
	public Coefficient() {
		
	}

	public Coefficient(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
