package org.mql.platform.dao.preregistration.impl;

import java.io.File;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.mql.platform.dao.StudentRepository;
import org.mql.platform.dao.preregistration.CandidateRepository;
import org.mql.platform.dao.preregistration.CoefficientRepository;
import org.mql.platform.models.ClassYear;
import org.mql.platform.models.Level;
import org.mql.platform.models.Student;
import org.mql.platform.models.preregistration.Candidate;
import org.mql.platform.models.preregistration.Candidates;
import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.tools.preregistration.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepositoryDefault implements CandidateRepository {

	/* object to initialize JAXB library */
	private JAXBContext jaxbContext;

	private Unmarshaller unmarshaller;
	
	private Marshaller marshaller;
	/******************************************/
	/* Repos used */
	
	private CoefficientRepository coefficientRepository;
	
	private StudentRepository studentRepository;
	
	private MailManager mailManager;
	
    /*************************************/
	@Autowired
	private ConfigurableEnvironment env;

	private String path;

	//Lists of candidates in different states

	private Candidates allCandidates;

	private Candidates selectedCandidates;

	private Candidates successfulList;

	private Candidates waintingList;

	private Candidates students;


	@Autowired
	public CandidateRepositoryDefault(CoefficientRepository coefficientRepository, StudentRepository studentRepository,
			MailManager mailManager) {
		this.coefficientRepository = coefficientRepository;
		this.studentRepository = studentRepository;
		this.mailManager = mailManager;
		try {
			jaxbContext = JAXBContext.newInstance(Candidates.class);
			unmarshaller = jaxbContext.createUnmarshaller();
			marshaller = jaxbContext.createMarshaller();
		} catch (Exception e) {
			System.out.println("error JAXB :" + e.getMessage());
		}
	}

	// create file and folder with current year
	public void createDirectory() {
		path = env.getProperty("resources") + "/" + Year.now().getValue() + "/";
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
	}

	// name of file
	public File getFile(String fileName) {
		createDirectory();
		File file = new File(path+ fileName + ".xml");
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (Exception e) {
				System.out.println("Error creating file  " + fileName + e.getMessage());
			}
		return file;
	}

	public boolean fileNotEmpty(String fileName) {
		File file = getFile(fileName);
		if (file.length() > 0)
			return true;
		return false;
	}

	@Autowired
	public void setAllCandidates(Candidates allCandidates) {
		if (fileNotEmpty("listCandidates"))
		{
			try {
				this.allCandidates = (Candidates) unmarshaller.unmarshal(getFile("listCandidates"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.allCandidates = allCandidates;
		}
	}

	@Autowired
	public void setSelectedCandidates(Candidates selectedCandidates) {
		if (fileNotEmpty("selected"))
		{
			try {
				this.selectedCandidates = (Candidates) unmarshaller.unmarshal(getFile("selected"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.selectedCandidates = selectedCandidates;
		}
	}

	@Autowired
	public void setSuccessfulList(Candidates successfulList) {
		if (fileNotEmpty("successful"))
		{
			try {
				this.successfulList = (Candidates) unmarshaller.unmarshal(getFile("successful"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.successfulList = successfulList;
		}
	}

	@Autowired
	public void setWaintingList(Candidates waintingList) {
		if (fileNotEmpty("wainting"))
		{
			try {
				this.waintingList = (Candidates) unmarshaller.unmarshal(getFile("waiting"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.waintingList = waintingList;
		}
	}

	@Autowired
	public void setStudents(Candidates students) {
		if (fileNotEmpty("students"))
		{
			try {
				this.students = (Candidates) unmarshaller.unmarshal(getFile("students"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.students = students;
		}
	}

	
	public void saveData(Candidates candidates, String fileName) {
		try {
			// MARSHALLER writing Java objects to XML documents.
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(candidates, getFile(fileName));

		} catch (Exception e) {
			System.out.println("Error save candidates in file :" + e.getMessage());
		}
	}

	public boolean add(Candidate candidate, Candidates candidates, String fileName) {
		if(candidate.getCin() != null) {
			for (Candidate candidate1 : candidates.getCandidates()) {
				// test if candidate exist
				if (candidate.getCne().equals(candidate1.getCne())) {
					return true;
				}
			}
			// candidate not exist
			candidate.getEducationLevels().setMark(coefficientRepository.calculateMark(candidate.getEducationLevels()));
			candidates.getCandidates().add(candidate);
			saveData(candidates, fileName);
		}
		return false;
	}

	public boolean update(Candidate cand, Candidates candidates, String fileName) {
		for (Candidate candidate : candidates.getCandidates()) {
			if (candidate.getCin().equals(cand.getCin())) {
				// remove candidate
				candidates.getCandidates().remove(candidate);
				// save candidates root
				saveData(candidates, fileName);
				// save modification
				add(cand, candidates, fileName);
				return true;
			}
		}
		return false;
	}

	public void delete(String cne, Candidates candidates, String fileName) {
		List<Candidate> candidates2 = (List<Candidate>) candidates.getCandidates();
		for (Candidate candidate : candidates2) {
			if (candidate.getCne().equals(cne)) {
				// remove candidate from list and save candidates root
				candidates2.remove(candidate);
				candidates.setCandidates(candidates2);
				saveData(candidates, fileName);
			}
		}
	}

	public Candidate searchByCne(String cne, Candidates candidates) {
		for (Candidate candidate : candidates.getCandidates()) {
			if (candidate.getCne().equals(cne)) {
				return candidate;
			}
		}
		return null;
	}

	// save candidate success to pass written test
	public void selected(double mark, Candidates candidates1, Candidates candidates2, String fileName) {
		for (Candidate candidate : candidates1.getCandidates()) {
			if (candidate.getEducationLevels().getMark() >= mark) {
				add(candidate, candidates2, fileName);
			}
		}
	}

	public List<Candidate> getAll(Candidates candidates) {
		return candidates.getCandidates();
	}
	
	public double getMark() {
		return 0;
	}

	public boolean addCandidate(Candidate candidate) {
		return add(candidate, allCandidates, "listCandidates");
	}

	public boolean updateCandidate(Candidate candidate) {
		return update(candidate, allCandidates, "listCandidates");
	}

	public Candidate searchCandidateByCne(String cne) {
		return searchByCne(cne, allCandidates);
	}

	public List<Candidate> getAllCandidates() {
		return getAll(allCandidates);
	}

	public void saveSelected(double mark) {
		selected(mark, allCandidates, selectedCandidates, "selected");

	}

	public List<Candidate> getAllSelectedCandidates() {
		return getAll(selectedCandidates);
	}

	public Candidate searchSelectedByCne(String cne) {
		return searchByCne(cne, selectedCandidates);
	}

	public void saveSucceededCandidates(String cne) {
		Candidate candidate = searchByCne(cne, selectedCandidates);
		if (candidate != null)
			add(candidate, successfulList, "successful");
	}

	public void saveWaitingList(String cne) {
		Candidate candidate = searchByCne(cne, selectedCandidates);
		add(candidate, waintingList, "waintingList");
	}

	public List<Candidate> getSucceededCandidates() {
		return getAll(successfulList);
	}

	public List<Candidate> getWaitingList() {
		return getAll(waintingList);
	}

	public Candidate searchSuccessfulCandidatesByCne(String cne) {
		return searchByCne(cne, successfulList);
	}

	public Candidate searchWaitingCandidatesByCne(String cne) {
		return searchByCne(cne, waintingList);
	}

	public void saveFinalCandidate(String cne) {
		Candidate candidate = searchSuccessfulCandidatesByCne(cne);
		if (candidate != null) {
			add(candidate, students, "students");
		} else {
			candidate = searchWaitingCandidatesByCne(cne);
			add(candidate, waintingList, "students");
		}
	}
	
	public void saveFinalCandidates() {
		for (Candidate candidate : students.getCandidates()) {
			Student student = new Student();
			student.setFirstName(candidate.getFirstName());
			student.setLastName(candidate.getLastName());
			student.setCin(candidate.getCin());
			student.setCne(candidate.getCne());
			student.setBirthdate(candidate.getBirthDate());
			student.setEmail(candidate.getEmail());
			student.setGender(candidate.getGender());
			student.setStatus(candidate.getStatus());
			student.setLevel(Level.M1);
			student.setPhoneNumber(candidate.getPhoneNumber());
			String password = mailManager.randomAlphaNumeric();
			mailManager.sendEmail(candidate.getEmail(), password);
			student.setPassword(mailManager.MD5(password));
			ClassYear classYear = new ClassYear();
			classYear.setBegin(LocalDate.now().getYear());
			classYear.setEnd(LocalDate.now().getYear() + 2);
			student.setClassYear(classYear);
			
			studentRepository.save(student);
		}
	}
}
