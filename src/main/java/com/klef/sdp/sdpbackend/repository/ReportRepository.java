package com.klef.sdp.sdpbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByObserverId(Long observerId);

  List<Report> findByLocation(String location);
}