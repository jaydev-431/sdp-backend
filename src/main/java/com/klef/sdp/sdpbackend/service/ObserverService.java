package com.klef.sdp.sdpbackend.service;

import java.util.List;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.entity.Report;

public interface ObserverService {
      Report addReport(Report report);
      List<Report> getReportsByObserver(Long observerId);
      Report updateReportStatus(Long id, String status);
      long totalReports();
      long countByStatus(String status);
      List<Report> getReportsByLocation(String location);
      long totalReportsByObserver(Long observerId);
      long countByStatusAndObserver(String status, Long observerId);
  
      public Observer verifyObserverLogin(String email,String password);
}