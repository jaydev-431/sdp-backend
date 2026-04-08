package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Analyst;
import java.util.List;


public interface AnalystRepository extends JpaRepository<Analyst, Long>{
	
Analyst  findByEmail(String email);

boolean existsById(Long id);
}
