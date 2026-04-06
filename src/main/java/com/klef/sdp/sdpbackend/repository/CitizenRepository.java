package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Citizen;
import java.util.List;


public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	
	Citizen  findByEmailAndPassword(String email, String password);
}
