package org.mql.platform.models.preregistration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Candidates {
	@XmlElement(name="candidate")
	private List<Candidate> candidates;
	
	public Candidates() {
		candidates = new ArrayList<>();
	}

	public Candidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	
}
