package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Observer;

public interface ObserverRepository extends JpaRepository<Observer, Long>{
	
	Observer findByEmailAndPassword(String email,String password);
	
}
