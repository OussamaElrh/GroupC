package org.mql.platform.business.preregistration.impl;

import java.util.List;

import org.mql.platform.business.preregistration.CandidateService;
import org.mql.platform.dao.preregistration.CandidateRepository;
import org.mql.platform.models.preregistration.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceDefault implements CandidateService{
	
	@Autowired
	private CandidateRepository repository;
	
	public boolean addCandidate(Candidate candidate) {
		return repository.addCandidate(candidate);
	}

	public boolean updateCandidate(Candidate candidate) {
		return repository.updateCandidate(candidate);
	}

	public Candidate searchCandidateByCne(String cne) {
		return repository.searchCandidateByCne(cne);
	}

	public List<Candidate> getAllCandidates() {
		return repository.getAllCandidates();
	}

	public void saveSelected(double mark) {
		repository.saveSelected(mark);
	}

	public List<Candidate> getAllSelectedCandidates() {
		return repository.getAllSelectedCandidates();
	}

	public Candidate searchSelectedByCne(String cne) {
		return repository.searchSelectedByCne(cne);
	}

	public void saveSucceededCandidates(String cne) {
		repository.saveSucceededCandidates(cne);
	}

	public void saveWaitingList(String cne) {
		repository.saveWaitingList(cne);
	}

	public List<Candidate> getSucceededCandidates() {
		return repository.getSucceededCandidates();
	}

	public List<Candidate> getWaitingList() {
		return repository.getWaitingList();
	}

	public Candidate searchSuccessfulCandidatesByCne(String cne) {
		return repository.searchSuccessfulCandidatesByCne(cne);
	}

	public Candidate searchWaitingCandidatesByCne(String cne) {
		return repository.searchWaitingCandidatesByCne(cne);
	}

	public void saveFinalCandidate(String cne) {
		repository.saveFinalCandidate(cne);
	}
	
	public void saveFinalCandidates() {
		
	}
}
