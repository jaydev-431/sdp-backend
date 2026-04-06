package com.klef.sdp.sdpbackend.service;

import java.util.List;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Comment;
import com.klef.sdp.sdpbackend.entity.Discussion;
import com.klef.sdp.sdpbackend.entity.Issue;

public interface CitizenService {
public String addIssue(Issue rep);
public List<Discussion> viewDiscussions();
public String addDiscussion(Discussion d);
public Citizen verifyCitizenLogin(String email , String password );
public String CitizenRegister(Citizen c);
public List<Issue> viewMyIssues();

//public 
}
