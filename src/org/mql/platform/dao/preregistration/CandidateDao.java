package org.mql.platform.dao.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Candidate;

public interface CandidateDao {
	public void addSuccessCandidate(List<Candidate> candidates);
}
