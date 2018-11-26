package org.mql.platform.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author chermehdi
 */
@Entity
public class Team {

  @EmbeddedId
  private TeamId id;

  @ManyToMany
  private Set<Student> members = new HashSet<>();

  private LocalDate creationYear = LocalDate.now();

  public Team() {
  }

  public Set<Student> getMembers() {
    return members;
  }

  public void setMembers(Set<Student> members) {
    this.members = members;
  }

  public TeamId getId() {
    return id;
  }

  public void setId(TeamId id) {
    this.id = id;
  }

  public String getName() {
    return id.getName();
  }

  public void setName(String name) {
    this.id.setName(name);
  }

  public LocalDate getCreationYear() {
    return creationYear;
  }

  public void setCreationYear(LocalDate year) {
    this.creationYear = year;
  }
}
