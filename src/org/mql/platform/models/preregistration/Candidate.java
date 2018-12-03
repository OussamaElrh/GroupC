package org.mql.platform.models.preregistration;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.mql.platform.models.Address;
import org.mql.platform.models.Gender;
import org.mql.platform.models.Status;
import org.mql.platform.tools.preregistration.LocalDateAdapter;

@XmlRootElement(name="candidate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidate {

	//testPush
	private String cin;
	private String cne;
	private String lastName;
	private String firstName;
	
	@XmlJavaTypeAdapter(type=LocalDate.class , value=LocalDateAdapter.class)
	private LocalDate birthDate;
	private Status status;
	private Address address;
	private Gender gender;
	private String email;
	private String phoneNumber;
	private EducationLevels educationLevels;

	public Candidate() {
		
	}

	public Candidate(String cin, String cne, int preregistrationYear, String lastName, String firstName,
			LocalDate birthDate, Status status, Address address, Gender gender, String email, String phoneNumber,
			EducationLevels educationLevels) {
		super();
		this.cin = cin;
		this.cne = cne;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.status = status;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.educationLevels = educationLevels;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EducationLevels getEducationLevels() {
		return educationLevels;
	}

	public void setEducationLevels(EducationLevels educationLevels) {
		this.educationLevels = educationLevels;
	}
	
}
