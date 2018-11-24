package org.mql.platform.business.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;

public interface CoefficientService {
	
	void add(Coefficient coefficient);

	void delete(Coefficient coefficient);

	void update(String name, double value);

	Coefficient search(String name);
	
	List<Coefficient> list();

	double markCalculate(EducationLevels educationLevels);
}
