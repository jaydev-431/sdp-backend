package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.repository.AnalystRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;

@Service
public class AnalystServiceImpl implements AnalystService {

    private final AnalystRepository analystRepository;
    private final IssueRepository issueRepository;

    public AnalystServiceImpl(AnalystRepository analystRepository, IssueRepository issueRepository) {
        this.analystRepository = analystRepository;
        this.issueRepository = issueRepository;
    }

    @Override
    public Analyst verifyAnalystLogin(String email, String password) {
        return analystRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public List<Issue> getIssuesByPollingstation(String pollingstation) {
        return issueRepository.findByPollingStation(pollingstation);
    }

    @Override
    public Issue updateIssueStatus(Long id, String status) {
        Issue issue = issueRepository.findById(id).orElse(null);

        if (issue != null) {
            issue.setStatus(status);
            return issueRepository.save(issue);
        }

        return null;
    }

    @Override
    public String generateReport() {
        List<Issue> issues = issueRepository.findAll();

        long total = issues.size();
        long resolved = issues.stream()
                .filter(i -> i.getStatus().equalsIgnoreCase("Resolved"))
                .count();

        long pending = total - resolved;

        return "Total Issues: " + total +
               ", Resolved: " + resolved +
               ", Pending: " + pending;
    }
}