package org.mql.platform.business.preregistration.impl;

import java.util.List;

import org.mql.platform.business.preregistration.CoefficientService;
import org.mql.platform.dao.preregistration.CoefficientDao;
import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoefficientServiceDefault implements CoefficientService{
	
	@Autowired
	private CoefficientDao coefficientDao;
	
	public CoefficientServiceDefault(CoefficientDao coefficientDao) {
		this.coefficientDao = coefficientDao;
	}

	public void addCoefficient(Coefficient coefficient) {
		coefficientDao.add(coefficient);
	}

	public void deleteCoefficient(Coefficient coefficient) {
		coefficientDao.delete(coefficient);
	}

	public void updateCoefficient(String name, double value) {
		coefficientDao.update(name, value);
	}

	public Coefficient searchCoefficient(String name) {
		return coefficientDao.search(name);
	}

	public double calculateMark(EducationLevels educationLevels) {
		return coefficientDao.calculateMark(educationLevels);
	}

	public List<Coefficient> listOfCoefficient() {
		return coefficientDao.list();
	}

}
