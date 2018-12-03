package org.mql.platform.business.projects;

import java.util.Set;
import org.mql.platform.models.Document;
import org.mql.platform.models.Project;
import org.mql.platform.models.Team;

/**
 * @author chermehdi
 */
public interface ProjectService {

  /**
   * Establishes a relation between the team and project, it assumes that both the team and the
   * project are valid entities
   *
   * @return true if the assignments succeeds, false otherwise
   */
  boolean assignTeamToProject(Team team, Project project);

  /**
   * Establishes a relation between the given Document and the project, it asumes that both the
   * document and the project are valid entities
   *
   * @return true if the assignments succeeds,false otherwise
   */
  boolean assignDocumentToProject(Document document, Project project);

  /**
   * Creates a project entity and saves it in the database, it supposes that the documents and teams
   * passed are valid entities
   *
   * @return the created project, or null if an error occurred during save
   */
  Project createProject(Set<Document> documents, Set<Team> teams);

  /**
   * Creates a project based on the given team, team must be an already saved entity
   *
   * @return the created project, or null if an error occurred during save
   */
  Project createProject(Team team);
}
