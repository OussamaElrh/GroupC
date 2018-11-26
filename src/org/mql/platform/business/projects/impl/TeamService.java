package org.mql.platform.business.projects.impl;

import java.util.Optional;
import java.util.Set;
import org.mql.platform.models.Project;
import org.mql.platform.models.Student;
import org.mql.platform.models.Team;

/**
 * @author chermehdi
 */
public interface TeamService {

  /**
   * Creates a team based on the students and the project passed as parameters, it assumes the
   * project and the students are valid entities
   *
   * @return the created team or null if an error happened
   */
  Optional<Team> createTeam(Set<Student> students, Project project);

  /**
   * Creates a team based on the students and the projects passed as parameters, it assumes the *
   * projects and the students are valid entities
   *
   * @return the created team of null if an error happened
   */
  Optional<Team> createTeam(Set<Student> students, Set<Project> project);

  /**
   * Assigns a student to the given team, it assumes that both the team and the student are valid
   * entities
   *
   * @return true if the assignments succeeds, false otherwise
   */
  boolean assignStudent(Student student, Team team);
}
