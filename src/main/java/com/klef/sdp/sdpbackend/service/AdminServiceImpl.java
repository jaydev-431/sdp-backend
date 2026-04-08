package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.repository.AdminRepository;
import com.klef.sdp.sdpbackend.repository.AnalystRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	public AdminRepository adminrepo;
	
	@Autowired
	public ObserverRepository observerRepo;
	
	@Autowired
	public AnalystRepository analystRepo;
	
	@Autowired
	public IssueRepository issuerepo;

	@Override
	public Admin verifyAdminLogin(String username, String password) {
		Admin a = adminrepo.findByUsernameAndPassword(username, password);
		if(a!=null) {
			return a;
		}else {
		return null;
		}
	}

	@Override
	public List<Observer> viewAllObservers() {
		return observerRepo.findAll();
	}

	@Override
	public List<Analyst> viewAllAnalysts() {
		
		return analystRepo.findAll();
	}

	@Override
	public String deleteObserver(Long id) {
		if(observerRepo.existsById(id)) {
			observerRepo.deleteById(id);
			return "Observer Deleted Successfully";
		}
		return "Not found";
	}
	@Override
	public String deleteAnalyst(Long id) {
		if(analystRepo.existsById(id)) {
		analystRepo.deleteById(id);
		return "Analyst deleted successfully";
	}else {
			return "not found";
	}
	}
	@Override
	public String addObserver(Observer ob) {
		observerRepo.save(ob);
		return "observer added successfully";
	}
	@Override
	public String addAnalyst(Analyst an) {
		analystRepo.save(an);
		return "Analyst added successfully";
	}
	@Override
	public List<Issue> viewAllIssues() {
		return issuerepo.findAll();	
	}
}
