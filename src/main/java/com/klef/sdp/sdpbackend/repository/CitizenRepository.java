package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Issue;

import java.util.List;


public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	
	Citizen  findByEmailAndPassword(String email, String password);
	
	
//	@Query("select i from Issue i where citizen_id=")
}
