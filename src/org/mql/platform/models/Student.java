package org.mql.platform.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

/**
 * @author mehdithe
 */
@Entity
public class Student extends User {

  private String cne;

  private String cin;

  private LocalDate birthdate;

  @Enumerated
  private Level level;

  @Enumerated
  private Status status;

  @OneToOne
  private Internship endOfStudiesProject;

  private ClassYear classYear;

  public Internship getEndOfStudiesProject() {
    return endOfStudiesProject;
  }

  public void setEndOfStudiesProject(Internship endOfStudiesProject) {
    this.endOfStudiesProject = endOfStudiesProject;
  }

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

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
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

  public ClassYear getClassYear() {
    return classYear;
  }

  public void setClassYear(ClassYear classYear) {
    this.classYear = classYear;
  }
 
}