package org.mql.platform.models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Laureate extends Student {
   
	public Laureate()
	{
		super();
	}

	public Laureate(Integer id, String firstName, String lastName, String phoneNumber, String email, String password,
			Gender gender, Address address, String cne, String cin, LocalDate birthday, Level level, Status status) {
		super(id, firstName, lastName, phoneNumber, email, password, gender, address, cne, cin, birthday, level,
				status);
		
	}
	
}
