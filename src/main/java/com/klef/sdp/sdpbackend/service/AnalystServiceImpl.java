package com.klef.sdp.sdpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.repository.AnalystRepository;

@Service
public class AnalystServiceImpl implements AnalystService{
	@Autowired
	private AnalystRepository analystRepository;

	@Override
	public Analyst verifyAnalystLogin(String email, String pwd) 
	{
		Analyst a = analystRepository.findByEmail(email);

		if (a != null && a.getPassword().equals(pwd)) {
		    return a;
		}
		return null;
	}
	
}
