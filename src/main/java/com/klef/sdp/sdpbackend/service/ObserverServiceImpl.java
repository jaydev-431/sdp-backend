package com.klef.sdp.sdpbackend.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.repository.CitizenRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;


@Service
public class ObserverServiceImpl implements ObserverService{

	@Autowired
	public ObserverRepository observerRepo;
	
	@Autowired
	public CitizenRepository citizenRepo;
	
	@Autowired
	public IssueRepository issuerRepo;
	
	
	@Override
	public List<Issue> viewAllIssues() {
		
		return issuerRepo.findAll();
	}

	@Override
	public List<Citizen> viewAllCitizens() {
		return citizenRepo.findAll();
	}

	@Override
	public Observer verifyObserverLogin(String email, String password) {
		return observerRepo.findByEmailAndPassword(email, password);
	}
	

	
}
