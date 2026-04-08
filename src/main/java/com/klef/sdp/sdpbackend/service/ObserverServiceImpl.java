package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.entity.Report;
import com.klef.sdp.sdpbackend.repository.CitizenRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;
import com.klef.sdp.sdpbackend.repository.ReportRepository; 

@Service
public class ObserverServiceImpl implements ObserverService {

    @Autowired
    public ObserverRepository observerRepo;

    @Autowired
    public CitizenRepository citizenRepo;

    @Autowired
    public IssueRepository issuerRepo;

    @Autowired
    public ReportRepository reportRepo; 

    @Override
    public Observer verifyObserverLogin(String email, String password) 
    {
        return observerRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public Report addReport(Report report)
    {
        report.setStatus("PENDING");
        return reportRepo.save(report);
    }

    @Override
    public List<Report> getReportsByObserver(Long observerId) 
    {
        return reportRepo.findByObserverId(observerId);
    }

    @Override
    public Report updateReportStatus(Long id, String status) 
    {
        Report report = reportRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setStatus(status);
        return reportRepo.save(report);
    }

    @Override
    public long totalReports()
    {
        return reportRepo.count();
    }

    public long countByStatus(String status) 
    {
        return reportRepo.findAll()
                .stream()
                .filter(r -> r.getStatus().equalsIgnoreCase(status))
                .count();
    }
    @Override
    public List<Report> getReportsByLocation(String location) 
    {
        return reportRepo.findByLocation(location);
    }
    @Override
    public long totalReportsByObserver(Long observerId) 
    {
        return reportRepo.findByObserverId(observerId).size();
    }

    @Override
    public long countByStatusAndObserver(String status, Long observerId) 
    {
        return reportRepo.findByObserverId(observerId)
                .stream()
                .filter(r -> r.getStatus().equalsIgnoreCase(status))
                .count();
    }
}