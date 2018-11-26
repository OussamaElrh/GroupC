package org.mql.platform.business.projects;

import java.util.List;
import java.util.Optional;
import org.mql.platform.dao.ProjectRepository;
import org.mql.platform.dao.TeamRepository;
import org.mql.platform.models.Project;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
