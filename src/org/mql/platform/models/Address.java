package org.mql.platform.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mehdithe
 */
@Entity
@XmlRootElement
public class Address {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String city;

  private int postalCode;

  private String address;

  /*@OneToOne(mappedBy = "address")
  private User owner;*/
  
  public Address(String city, int postalCode, String address) {
	super();
	this.city = city;
	this.postalCode = postalCode;
	this.address = address;
  }

public Address() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  /*public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }*/
}
