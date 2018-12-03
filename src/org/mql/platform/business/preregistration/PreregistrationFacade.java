package org.mql.platform.business.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Candidate;
import org.mql.platform.models.preregistration.Coefficient;
import org.mql.platform.models.preregistration.EducationLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 
 *Busines façade
 *
 **/
@Service
public class PreregistrationFacade {

	private CandidateService candidateService;

	private CoefficientService coefficientService;
	
	@Autowired
	public PreregistrationFacade(CandidateService candidateService, CoefficientService coefficientService) {
		this.setCandidateService(candidateService);
		this.setCoefficientService(coefficientService);
	}

	public boolean addCandidate(Candidate candidate) {
		return candidateService.addCandidate(candidate);
	}

	public boolean updateCandidate(Candidate candidate) {
		return candidateService.updateCandidate(candidate);
	}

	public Candidate searchCandidateByCne(String cne) {
		return candidateService.searchCandidateByCne(cne);
	}

	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	public void saveSelected(double mark) {
		candidateService.saveSelected(mark);
	}

	public List<Candidate> getAllSelectedCandidates() {
		return candidateService.getAllSelectedCandidates();
	}

	public Candidate searchSelectedByCne(String cne) {
		return candidateService.searchSelectedByCne(cne);
	}

	public void saveSucceededCandidates(String cne) {
		candidateService.saveSucceededCandidates(cne);
	}

	public void saveWaitingList(String cne) {
		candidateService.saveWaitingList(cne);
	}

	public List<Candidate> getSucceededCandidates() {
		return candidateService.getSucceededCandidates();
	}

	public List<Candidate> getWaitingList() {
		return candidateService.getWaitingList();
	}

	public Candidate searchSuccessfulCandidatesByCne(String cne) {
		return candidateService.searchSuccessfulCandidatesByCne(cne);
	}

	public Candidate searchWaitingCandidatesByCne(String cne) {
		return candidateService.searchWaitingCandidatesByCne(cne);
	}

	public void saveFinalCandidate(String cne) {
		candidateService.saveFinalCandidate(cne);
	}

	public void saveFinalCandidates() {
		candidateService.saveFinalCandidates();
	}

	public void addCoefficient(Coefficient coefficient) {
		coefficientService.addCoefficient(coefficient);
	}

	public void deleteCoefficient(Coefficient coefficient) {
		coefficientService.deleteCoefficient(coefficient);
	}

	public void updateCoefficient(String name, double value) {
		coefficientService.updateCoefficient(name, value);
	}

	public Coefficient searchCoefficient(String name) {
		return coefficientService.searchCoefficient(name);
	}

	public List<Coefficient> listOfCoefficient() {
		return coefficientService.listOfCoefficient();
	}

	public double calculateMark(EducationLevels educationLevels) {
		return coefficientService.calculateMark(educationLevels);
	}

	public CandidateService getCandidateService() {
		return candidateService;
	}

	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	public CoefficientService getCoefficientService() {
		return coefficientService;
	}

	public void setCoefficientService(CoefficientService coefficientService) {
		this.coefficientService = coefficientService;
	}

}
