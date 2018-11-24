package org.mql.platform.dao.impl.preregistration;

import java.util.List;

import org.mql.platform.dao.StudentRepository;
import org.mql.platform.dao.preregistration.CandidateDao;
import org.mql.platform.models.Address;
import org.mql.platform.models.Level;
import org.mql.platform.models.Student;
import org.mql.platform.models.preregistration.Candidate;
import org.mql.platform.tools.preregistration.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateDaoDefault implements CandidateDao{
	
	private MailManager manager = new MailManager();;
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private JpaRepository<Address, Integer> addressRepository;
	
	
	public List<Candidate> getValidateCandidate(){
		return null;
	}
	
	@Override
	public void addSuccessCandidate(List<Candidate> candidates) {
		for (Candidate candidate : candidates) {
			String password = manager.randomAlphaNumeric();
			Student student = new Student(candidate.getFirstName(), candidate.getLastName(),
			candidate.getPhoneNumber(), candidate.getEmail(), manager.MD5(password),
			candidate.getGender(), candidate.getAdress(), candidate.getCne(),
			candidate.getCin(), candidate.getBirthDate(), Level.M1, candidate.getStatus());
			System.out.println(candidate.getAdress().getCity());
			System.out.println(candidate.getAdress().getAddress());
			System.out.println(candidate.getAdress().getPostalCode());
			addressRepository.save(candidate.getAdress());
			repository.save(student);
		}
	}
}
