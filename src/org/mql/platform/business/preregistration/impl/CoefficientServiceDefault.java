package org.mql.platform.business.preregistration.impl;

import java.util.List;

import org.mql.platform.business.preregistration.CoefficientService;
import org.mql.platform.dao.preregistration.CoefficientRepository;
import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoefficientServiceDefault implements CoefficientService{
	
	@Autowired
	private CoefficientRepository coefficientDao;
	
	public CoefficientServiceDefault(CoefficientRepository coefficientDao) {
		this.coefficientDao = coefficientDao;
	}

	public void addCoefficient(Coefficient coefficient) {
		coefficientDao.addCoefficient(coefficient);
	}

	public void deleteCoefficient(Coefficient coefficient) {
		coefficientDao.deleteCoefficient(coefficient);
	}

	public void updateCoefficient(String name, double value) {
		coefficientDao.updateCoefficient(name, value);
	}

	public Coefficient searchCoefficient(String name) {
		return coefficientDao.searchCoefficient(name);
	}

	public double calculateMark(EducationLevels educationLevels) {
		return coefficientDao.calculateMark(educationLevels);
	}

	public List<Coefficient> listOfCoefficient() {
		return coefficientDao.list();
	}

}
