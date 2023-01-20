package com.thym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thym.entity.Candidate;
import com.thym.service.CandidateService;

@Controller
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	
	@GetMapping("/test")
	public String test() {
		Candidate candidate = new Candidate("ValliAmmal",92,"Oru suthi");
		candidateService.saveCandidate(candidate);
		return "candidate";
	}
	
	
	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("candidate", candidateService.findAllCandidates());
		return "all-candidate";
	}
	
	@GetMapping("/add")
	public String addCandidate(Model model) {
		model.addAttribute("candidate", new Candidate());
		return "add-candidate";
	}
	
	@PostMapping("/saveCandidate")
	public String saveCandidate(Candidate candidate) {
        candidateService.saveCandidate(candidate);
		return "redirect:/"; //URI should present here
	}
	
	@GetMapping("/edit/{id}")
	public String editCandidate(@PathVariable("id") long id, Model model) {
	     model.addAttribute("candidate", candidateService.findCandidateById(id));
	     return "edit-candidate";
	}
	
	@PostMapping("/updateCandidate")
	public String updateCandidate(Candidate candidate) {
		candidateService.updateCandidate(candidate);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCandidateById(@PathVariable("id") long id) {
		candidateService.deleteCandidateById(id);
		return "redirect:/";
	}
}
