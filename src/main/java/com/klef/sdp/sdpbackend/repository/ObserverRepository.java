package com.klef.sdp.sdpbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.entity.Report;

public interface ObserverRepository extends JpaRepository<Observer, Long>{
  
  Observer findByEmailAndPassword(String email,String password);
  List<Report> findBylocation(String location);
  
  boolean existsById(Long id);
}