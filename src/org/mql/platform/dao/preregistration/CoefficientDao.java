package org.mql.platform.dao.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;
import org.springframework.stereotype.Repository;

public interface CoefficientDao {
	/**
	 * 
	 * interface to define Dao methods for Coefficient
	 * 
	 *
	 */

	public void add(Coefficient coefficient);

	public void delete(Coefficient coefficient);

	public void update(String name, double value);

	public Coefficient search(String name);
	
	public List<Coefficient> list();

	/**
	 * 
	 * method for calculating the pre-selection average of a candidate
	 *
	 */
	public double calculateMark(EducationLevels educationLevels);
}
