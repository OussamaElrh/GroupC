package org.mql.platform.models;

import javax.persistence.Entity;

/**
 * @author mehdithe

 */
@Entity
public class Professor extends User {

	public Professor(Integer id, String firstName, String lastName, String phoneNumber, String email, String password,
			Gender gender, Address address) {
		super(id, firstName, lastName, phoneNumber, email, password, gender, address);

	}

	public Professor() {
		super();
	}

}
