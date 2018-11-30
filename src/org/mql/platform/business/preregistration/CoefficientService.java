package org.mql.platform.business.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;

public interface CoefficientService {
	
	public void addCoefficient(Coefficient coefficient);

	public void deleteCoefficient(Coefficient coefficient);

	public void updateCoefficient(String name, double value);

	public Coefficient searchCoefficient(String name);
	
	public List<Coefficient> listOfCoefficient();

	public double calculateMark(EducationLevels educationLevels);
}
