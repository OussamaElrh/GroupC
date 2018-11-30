package org.mql.platform.dao.preregistration.impl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.mql.platform.dao.preregistration.CoefficientDao;
import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.Coefficients;
import org.mql.platform.models.preregistration.EducationLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Repository;

@Repository
public class CoefficientDaoDefault implements CoefficientDao {
	
	@Autowired
	ConfigurableEnvironment env;
	
	private Coefficients coefficients;
	private JAXBContext jaxbContext;

	public CoefficientDaoDefault() {
		try {
			this.jaxbContext = JAXBContext.newInstance(Coefficients.class);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	/**
	 * Method that create file if not exist
	 * 
	 * @return xml coefficients
	 */
	public File getFile() {
		String path = env.getProperty("resources");
		File directory = new File(path);
		if(!directory.exists())
			directory.mkdirs();
		File file = new File(path + "coefficients.xml");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
			}
		}
		return file;
	}
	
	public boolean FileNotEmpty(File file) {
		if(file.length() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Method that loads from xml file our coefs
	 * 
	 * @return our coefficients as class coefficients
	 * @throws JAXBException
	 */
	@Autowired
	public void setCoefficients(Coefficients coefficients) {
		if(!load())
			this.coefficients = coefficients;
	}

	
	public boolean load() {
		if(FileNotEmpty(getFile())) {
			try {
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				coefficients = (Coefficients) jaxbUnmarshaller.unmarshal(getFile());
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
			}
			return true;
		}else
			return false;
	}
	
	
	public void save() {
		try {
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Marshal the coefficients list in file
			jaxbMarshaller.marshal(coefficients, getFile());
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void add(Coefficient coefficient) {
		
		if(search(coefficient.getName()) != null) {
			update(coefficient.getName(), coefficient.getValue());
		}
		else {
			coefficients.getCoefficients().add(coefficient);
			save();
		}
	}

	public void delete(Coefficient coefficient) {
		coefficients.getCoefficients().remove(coefficient);
		save();
	}

	/**
	 * Attention allow updating coef value by its name only !
	 * 
	 * @param
	 */
	public void update(String name, double value) {
		for (Coefficient coef : coefficients.getCoefficients()) {
			if (coef.getName().equals(name))
				coef.setValue(value);
		}
		save();
	}

	public Coefficient search(String name) {
		if(coefficients.getCoefficients() != null) {
			for (Coefficient coef : coefficients.getCoefficients()) {
				if (coef.getName().contains(name))
					return coef;
			}
		}
		return null;
	}
	
	public List<Coefficient> list() {
		return coefficients.getCoefficients();
	}

	public double calculateMark(EducationLevels educationLevels) {
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
		if (search(city) != null)
			coeffCity = search(city).getValue();

		// Default establishment coefficient
		double coeffEstablishment = search("coeffEstablishment").getValue();
		// If establishment coefficient exist
		if (search(establishment) != null)
			coeffEstablishment = search(establishment).getValue();

		int currentYear = LocalDate.now().getYear();
		mark = s1 * educationLevels.getS1Mark() + s2 * educationLevels.getS2Mark() + s3 * educationLevels.getS3Mark()
				+ s4 * educationLevels.getS4Mark() + s5 * educationLevels.getS5Mark() + s6 * educationLevels.getS6Mark()
				+ coeffCity + 3 - coeffEstablishment
				+ (educationLevels.getThirdLevelYear() - educationLevels.getBaccalaureateYear())
				- (currentYear - educationLevels.getThirdLevelYear());

		return mark;
	}

	
}
