package org.mql.platform.business.impl.preregistration;

import java.util.List;

import org.mql.platform.business.preregistration.CandidateService;
import org.mql.platform.dao.preregistration.CandidateDao;
import org.mql.platform.models.preregistration.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceDefault implements CandidateService{
	
	@Autowired
	private CandidateDao candidateDao;
	
	@Override
	public void addSuccessCandidates(List<Candidate> candidates) {
		candidateDao.addSuccessCandidate(candidates);
	}

}
