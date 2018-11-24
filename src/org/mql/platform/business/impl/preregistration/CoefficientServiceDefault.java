package org.mql.platform.business.impl.preregistration;

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

	public void add(Coefficient coefficient) {
		coefficientDao.add(coefficient);
	}

	public void delete(Coefficient coefficient) {
		coefficientDao.delete(coefficient);
	}

	public void update(String name, double value) {
		coefficientDao.update(name, value);
	}

	public Coefficient search(String name) {
		return coefficientDao.search(name);
	}

	public double markCalculate(EducationLevels educationLevels) {
		return coefficientDao.markCalculate(educationLevels);
	}

	public List<Coefficient> list() {
		return coefficientDao.list();
	}

}
