package org.mql.platform.business.preregistration;

import java.util.List;

import org.mql.platform.models.preregistration.Candidate;

public interface CandidateService {
	public void addSuccessCandidates(List<Candidate> candidates);
}
