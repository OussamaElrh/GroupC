package org.mql.platform.business.projects;

import org.mql.platform.dao.ProjectRepository;
import org.mql.platform.dao.TeamRepository;
import org.mql.platform.models.Project;
import org.springframework.stereotype.Service;

/**
 * @author chermehdi
 */
@Service
public class ProjectFacade {

  private final ProjectRepository projectRepository;

  private final TeamRepository teamRepository;

  public ProjectFacade(ProjectRepository projectRepository,
      TeamRepository teamRepository) {
    this.projectRepository = projectRepository;
    this.teamRepository = teamRepository;
  }

  Project findProject(Integer id) {
    return projectRepository.getOne(id);
  }
}
