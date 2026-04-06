package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Discussion;

public interface DiscussionsRepository extends JpaRepository<Discussion, Long>{
	

}
