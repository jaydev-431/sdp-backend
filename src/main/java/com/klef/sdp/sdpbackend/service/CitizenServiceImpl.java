package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Comment;
import com.klef.sdp.sdpbackend.entity.Discussion;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.repository.CitizenRepository;
import com.klef.sdp.sdpbackend.repository.CommentRepository;
import com.klef.sdp.sdpbackend.repository.DiscussionsRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;

@Service
public class CitizenServiceImpl implements CitizenService {
	
	@Autowired
	public CitizenRepository citizenrepo;
	
	@Autowired
	public IssueRepository issuerepo;
	
	@Autowired
	public CommentRepository commentrepo;
	
	@Autowired
	public DiscussionsRepository discussionrepo;

	@Override
	public String addIssue(Issue i) {
		issuerepo.save(i);
		return "Added successfully";
	}

	@Override
	public List<Discussion> viewDiscussions() {
		List<Discussion> d = discussionrepo.findAll();
		return d;
	}

	

	@Override
	public Citizen verifyCitizenLogin(String email, String password) {
		return citizenrepo.findByEmailAndPassword(email, password);
	}

	@Override
	public String CitizenRegister(Citizen c) {
		citizenrepo.save(c);
		return "Citizen added successfully";
	}

	@Override
	public String addDiscussion(Discussion d) {
		discussionrepo.save(d);
		return "saved successfully";
	}

	@Override
	public List<Issue> viewMyIssues() {
		List<Issue> i = issuerepo.findAll();
		return i;
	}

	
	

}
