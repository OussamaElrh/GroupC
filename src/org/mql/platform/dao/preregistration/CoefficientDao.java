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
	 * @author fatimaZahra
	 *
	 */

	void add(Coefficient coefficient);

	void delete(Coefficient coefficient);

	void update(String name, double value);

	Coefficient search(String name);
	
	List<Coefficient> list();

	/**
	 * 
	 * method for calculating the pre-selection average of a candidate
	 *
	 */
	double markCalculate(EducationLevels educationLevels);
}
