package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Analyst;


public interface AnalystRepository extends JpaRepository<Analyst, Long>
{
	Analyst findByEmailAndPassword(String email, String password);
	
	

}