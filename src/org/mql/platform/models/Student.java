package org.mql.platform.models;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * @author mehdithe
 */
@Entity
public class Student extends User {

	@OneToOne
	private Internship endOfStudiesProject;
	//
	// @ManyToMany
	// @JoinTable(
	// name = "student_module",
	// joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
	// inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName =
	// "id")
	// )
	// private Set<Module> modules;

	// @ManyToMany
	// @JoinTable(
	// name = "student_team",
	// joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
	// inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName =
	// "id")
	// )
	// private Set<Team> teams;

	private String cne;

	private String cin;

	private LocalDate birthday;

	@Enumerated
	private Level level;

	@Enumerated
	private Status status;

	public Internship getEndOfStudiesProject() {
		return endOfStudiesProject;
	}

	public void setEndOfStudiesProject(Internship endOfStudiesProject) {
		this.endOfStudiesProject = endOfStudiesProject;
	}

	// public Set<Module> getModules() {
	// return modules;
	// }
	//
	// public void setModules(Set<Module> modules) {
	// this.modules = modules;
	// }

	// public Set<Team> getTeams() {
	// return teams;
	// }
	//
	// public void setTeams(Set<Team> teams) {
	// this.teams = teams;
	// }

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Student() {

	}

	public Student(String firstName, String lastName, String phoneNumber, String email, String password,
			Gender gender, Address address, String cne, String cin, LocalDate birthday, Level level, Status status) {
		super(firstName, lastName, phoneNumber, email, password, gender, address);

		this.cne = cne;
		this.cin = cin;
		this.birthday = birthday;
		this.level = level;
		this.status = status;
	}

}
