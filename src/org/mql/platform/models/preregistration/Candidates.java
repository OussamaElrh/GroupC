package org.mql.platform.models.preregistration;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Candidates {
	@XmlElement(name="candidate")
	private List<Candidate> candidates;
	
	public Candidates() {
		candidates = new Vector<>();
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
