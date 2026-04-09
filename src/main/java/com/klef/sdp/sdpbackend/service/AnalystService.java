package com.klef.sdp.sdpbackend.service;

import java.util.List;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;

public interface AnalystService {

    public Analyst verifyAnalystLogin(String email, String password);

    public List<Issue> getAllIssues();

    public List<Issue> getIssuesByPollingstation(String pollingstation);

    public Issue updateIssueStatus(Long id, String status);

    public String generateReport();
}