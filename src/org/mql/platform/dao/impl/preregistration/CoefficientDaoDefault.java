package org.mql.platform.dao.impl.preregistration;

/**
 * 
 * class to implements CoefficientDao interface 
 * 
 * @author fatimaZahra
 * @author Abdelali
 */

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mql.platform.dao.preregistration.CoefficientDao;
import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.Coefficients;
import org.mql.platform.models.preregistration.EducationLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Repository;

@Repository
public class CoefficientDaoDefault implements CoefficientDao {
	
	@Autowired
	private ConfigurableEnvironment env;

	private Coefficients coefficients;
	
	public CoefficientDaoDefault() {
		try {
			coefficients = load();
		} catch (JAXBException e) {

		}
	}
	
	/**
	 * Method  for verifying if file exist or not
	 * @return file of coefficients
	 */
	private File coefFile() {
		File file = new File(env.getProperty("resources") + "/coefficients.xml");
		try {
			if(!file.exists())
				file.createNewFile();
			return file;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Method that loads from xml file our coefs
	 * 
	 * @return our coefficients as class coefficients
	 * @throws JAXBException
	 */
	private Coefficients load() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Coefficients.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Coefficients coeff = (Coefficients) jaxbUnmarshaller.unmarshal(coefFile());

		return coeff;
	}

	public void save() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Coefficients.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshal the coefficients list in file
		jaxbMarshaller.marshal(coefficients, coefFile());
	}

	public void add(Coefficient coefficient) {
		try {
			if(search(coefficient.getName()) != null) {
				update(coefficient.getName(), coefficient.getValue());
			}
			else {
			coefficients.getCoefficients().add(coefficient);
			save();
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void delete(Coefficient coefficient) {
		try {
			coefficients.getCoefficients().remove(coefficient);
			save();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Attention allow updating coef value by its name only !
	 * 
	 * @param
	 */
	public void update(String name, double value) {
		try {
			for (Coefficient coef : coefficients.getCoefficients()) {
				if (coef.getName().equals(name))
					coef.setValue(value);
			}
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Coefficient search(String name) {
		Coefficient coeff = null;
		try {
			for (Coefficient coef : coefficients.getCoefficients()) {
				if (coef.getName().contains(name))
					coeff = coef;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coeff;

	}
	
	public List<Coefficient> list() {
		return coefficients.getCoefficients();
	}

	public double markCalculate(EducationLevels educationLevels) {
		double mark = 1;
		double s1 = search("s1").getValue();
		double s2 = search("s2").getValue();
		double s3 = search("s3").getValue();
		double s4 = search("s4").getValue();
		double s5 = search("s5").getValue();
		double s6 = search("s6").getValue();
		String city = educationLevels.getThirdLevelCity();
		String establishment = educationLevels.getSecondeLevelEstablishment();

		// Default city coefficient
		double coeffCity = search("coeffCity").getValue();
		// If city coefficient exist
		if (!search(city).equals(null)) {
			coeffCity = search(city).getValue();
		}

		// Default establishment coefficient
		double coeffEstablishment = search("coeffEstablishment").getValue();
		// If establishment coefficient exist
		if (!search(establishment).equals(null)) {
			coeffEstablishment = search(establishment).getValue();
		}

		int currentYear = LocalDate.now().getYear();
		mark = s1 * educationLevels.getS1Mark() + s2 * educationLevels.getS2Mark() + s3 * educationLevels.getS3Mark()
				+ s4 * educationLevels.getS4Mark() + s5 * educationLevels.getS5Mark() + s6 * educationLevels.getS6Mark()
				+ coeffCity + 3 - coeffEstablishment
				+ (educationLevels.getThirdLevelYear() - educationLevels.getBaccalaureateYear())
				- (currentYear - educationLevels.getThirdLevelYear());

		return mark;
	}

	

}
