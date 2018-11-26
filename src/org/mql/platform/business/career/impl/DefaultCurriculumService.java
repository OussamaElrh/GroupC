package org.mql.platform.business.career.impl;

import java.util.List;

import org.mql.platform.business.career.CurriculumService;
import org.mql.platform.dao.EducationRepository;
import org.mql.platform.dao.ExperienceRepository;
import org.mql.platform.dao.LaureateRepository;
import org.mql.platform.dao.TechnologyRepository;
import org.mql.platform.models.Education;
import org.mql.platform.models.Experience;
import org.mql.platform.models.Laureate;
import org.mql.platform.models.Technology;
import org.springframework.transaction.annotation.Transactional;

public class DefaultCurriculumService implements CurriculumService {

  private final LaureateRepository laureateRepository;

  private final TechnologyRepository technologyRepository;

  private final EducationRepository educationRepository;

  private final ExperienceRepository experienceRepository;

  public DefaultCurriculumService(LaureateRepository laureateRepository,
      TechnologyRepository technologyRepository,
      EducationRepository educationRepository,
      ExperienceRepository experienceRepository) {
    this.laureateRepository = laureateRepository;
    this.technologyRepository = technologyRepository;
    this.educationRepository = educationRepository;
    this.experienceRepository = experienceRepository;
  }

  public Laureate getLaureate(Integer id) {
    return laureateRepository.getOne(id);
  }


  public List<Technology> getAllTechnologys() {
    return technologyRepository.findAll();
  }

  @Override
  public List<Education> getAllEducations() {
    return educationRepository.findAll();
  }

  public List<Experience> getAllExperiences() {
    return experienceRepository.findAll();
  }

  public Technology getTechnology(Integer id) {
    return technologyRepository.getOne(id);
  }

  public Education getEducation(Integer id) {
    return educationRepository.getOne(id);
  }

  public Experience getExperience(Integer id) {
    return experienceRepository.getOne(id);
  }

  @Transactional
  public boolean addOrUpdateTechnology(Technology technology) {
    return technologyRepository.save(technology) != null;
  }

  @Transactional
  public boolean addOrUpdateEducation(Education education) {
    return educationRepository.save(education) != null;
  }

  @Transactional
  public boolean addOrUpdateExperience(Experience experience) {
    return experienceRepository.save(experience) != null;
  }

  @Transactional
  public void deleteTechnology(Integer id) {
    technologyRepository.deleteById(id);
    ;
  }

  @Transactional
  public void deleteEducation(Integer id) {
    educationRepository.deleteById(id);
  }

  @Transactional
  public void deleteExperience(Integer id) {
    experienceRepository.deleteById(id);
  }

}
