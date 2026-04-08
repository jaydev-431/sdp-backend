package com.klef.sdp.sdpbackend.service;

import java.util.List;

import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.entity.Observer;

public interface AdminService {
public Admin verifyAdminLogin(String username , String password);
public List<Observer> viewAllObservers();
public List<Analyst> viewAllAnalysts();   
public String deleteObserver(Long id);
public String deleteAnalyst(Long id);
public String addObserver(Observer ob); 
public String addAnalyst(Analyst an);  
public List<Issue> viewAllIssues();
}
