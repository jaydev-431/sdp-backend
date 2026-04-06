package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	
	
}
