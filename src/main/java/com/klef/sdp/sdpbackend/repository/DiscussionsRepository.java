package com.klef.sdp.sdpbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.sdp.sdpbackend.entity.Discussion;

public interface DiscussionsRepository extends JpaRepository<Discussion, Long>{
	
	
	@Query("select d from Discussion d where d.citizen.id = ?1")
	List<Discussion> findmycomments(Long id);
}
