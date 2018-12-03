package org.mql.platform.dao.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;

public interface CoefficientRepository {
	/**
	 * 
	 * interface to define Dao methods for Coefficient
	 * 
	 *
	 */

	public void addCoefficient(Coefficient coefficient);

	public void deleteCoefficient(Coefficient coefficient);

	public void updateCoefficient(String name, double value);

	public Coefficient searchCoefficient(String name);
	
	public List<Coefficient> list();

	/**
	 * 
	 * method for calculating the pre-selection average of a candidate
	 *
	 */
	public double calculateMark(EducationLevels educationLevels);
}
