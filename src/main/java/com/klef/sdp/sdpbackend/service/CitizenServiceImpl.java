package com.klef.sdp.sdpbackend.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.dto.DiscussionDTO;
import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Discussion;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.repository.CitizenRepository;
import com.klef.sdp.sdpbackend.repository.DiscussionsRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;

@Service
public class CitizenServiceImpl implements CitizenService {
	
	@Autowired
	public CitizenRepository citizenrepo;
	
	@Autowired
	public IssueRepository issuerepo;
	
	
	@Autowired
	public DiscussionsRepository discussionrepo;

	@Override
	public String addIssue(Issue i) {
		issuerepo.save(i);
		return "Added successfully";
	}

	@Override
	public List<DiscussionDTO> viewDiscussions() {
		
		    List<Discussion> list = discussionrepo.findAll();

		    return list.stream().map(d -> {
		        DiscussionDTO dto = new DiscussionDTO();
		        dto.setId(d.getId());
		        dto.setComment(d.getComment());
		        dto.setCitizenId(d.getCitizen().getId());
		        dto.setCitizenName(d.getCitizen().getName());
		        dto.setAddedAt(d.getAddedAt());
		        return dto;
		    }).toList();
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
	public List<Issue> viewMyIssues(Long id) {
		List<Issue> i = issuerepo.findByCitizenId(id);
		return i;
	}

	@Override
	public List<Discussion> viewMyComments(Long id) {
		return discussionrepo.findmycomments(id);
		
	}

	
	@Override
	public String deleteMyComment(Long id) {
		discussionrepo.deleteById(id);
		return "deleted succesfuuly";
	}

	
}
