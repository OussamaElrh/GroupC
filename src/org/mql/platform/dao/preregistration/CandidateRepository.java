package org.mql.platform.dao.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Candidate;

public interface CandidateRepository {

	/*
	 * @method for adding a candidate
	 */
	public boolean addCandidate(Candidate candidate);
	
	/*
	 * @method for updating a candidate
	 */
	
	public boolean updateCandidate(Candidate candidate);
	
	/*
	 * @method for searching a candidate
	 */
	
	public Candidate searchCandidateByCne(String cne);
	
	/*
	 * @method for adding a candidate
	 */
	
	public List<Candidate> getAllCandidates();

	public void saveSelected(double mark);

	
	public List<Candidate> getAllSelectedCandidates();

	public Candidate searchSelectedByCne(String cne);

	public void saveSucceededCandidates(String cne);

	public void saveWaitingList(String cne);

	
	public List<Candidate> getSucceededCandidates();

	public List<Candidate> getWaitingList();

	public Candidate searchSuccessfulCandidatesByCne(String cne);

	public Candidate searchWaitingCandidatesByCne(String cne);

	public void saveFinalCandidate(String cne);
	
	public void saveFinalCandidates();
}
