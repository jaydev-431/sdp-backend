package com.klef.sdp.sdpbackend.service;

import java.util.List;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.entity.Observer;

public interface ObserverService {

	public List<Issue> viewAllIssues();
//	
//	public List<PollingStation> viewAllPollingStations();
	public List<Citizen> viewAllCitizens();
	
	public Observer verifyObserverLogin(String email,String passwird);
}
