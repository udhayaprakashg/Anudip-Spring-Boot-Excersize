package com.thym.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thym.entity.Candidate;
import com.thym.repository.CandidateRepository;
import com.thym.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public List<Candidate> findAllCandidates() {
		return candidateRepository.findAll();
	}

	@Override
	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate findCandidateById(long id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		if(candidate.isPresent()) {return candidate.get();}
		return new Candidate(); 
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		Optional<Candidate> result = candidateRepository.findById(candidate.getId());
		Candidate existing = result.get();
		existing.setName(candidate.getName());
		existing.setAge(candidate.getAge());
		existing.setCity(candidate.getCity());
		return candidateRepository.save(existing);
	}

	@Override
	public void deleteCandidateById(long id) {
		candidateRepository.deleteById(id);
		
	}

}
