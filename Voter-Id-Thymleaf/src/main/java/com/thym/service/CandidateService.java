package com.thym.service;

import java.util.List;

import com.thym.entity.Candidate;

public interface CandidateService {
	
	List<Candidate> findAllCandidates();
	
	Candidate saveCandidate(Candidate candidate);
	
	Candidate findCandidateById(long id);
	
	Candidate updateCandidate(Candidate candidate);
	
	void deleteCandidateById(long id);
	
	
}
