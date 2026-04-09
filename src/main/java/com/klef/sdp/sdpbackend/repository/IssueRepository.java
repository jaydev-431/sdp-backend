package com.klef.sdp.sdpbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

  
  List<Issue> findByCitizenId(Long id); 
  
  List<Issue> findByPollingStation(String pollingstation);
}