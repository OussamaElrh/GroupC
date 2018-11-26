package org.mql.platform.business.career;

import java.util.List;

import org.mql.platform.models.Education;
import org.mql.platform.models.Experience;
import org.mql.platform.models.Laureate;
import org.mql.platform.models.Technology;

public interface CurriculumService {

  Laureate getLaureate(Integer id);

  List<Technology> getAllTechnologys();

  List<Education> getAllEducations();

  List<Experience> getAllExperiences();

  Technology getTechnology(Integer id);

  Education getEducation(Integer id);

  Experience getExperience(Integer id);

  boolean addOrUpdateTechnology(Technology technology);

  boolean addOrUpdateEducation(Education education);

  boolean addOrUpdateExperience(Experience experience);

  void deleteTechnology(Integer id);

  void deleteEducation(Integer id);

  void deleteExperience(Integer id);
}
