package com.klef.sdp.sdpbackend.service;

import com.klef.sdp.sdpbackend.entity.Analyst;

public interface AnalystService 
{
	public Analyst verifyAnalystLogin(String email,String pwd);
}
