package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.repository.AdminRepository;
import com.klef.sdp.sdpbackend.repository.AnalystRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminRepository adminrepo;

    @Autowired
    public ObserverRepository observerRepo;

    @Autowired
    public AnalystRepository analystRepo;

    @Autowired
    public IssueRepository issuerepo;

    @Autowired
    private EmailService emailService;

    @Override
    public Admin verifyAdminLogin(String username, String password) {
        return adminrepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Observer> viewAllObservers() {
        return observerRepo.findAll();
    }

    @Override
    public List<Analyst> viewAllAnalysts() {
        return analystRepo.findAll();
    }

    @Override
    public String deleteObserver(Long id) {
        if (observerRepo.existsById(id)) {
            observerRepo.deleteById(id);
            return "Observer Deleted Successfully";
        }
        return "Not found";
    }

    @Override
    public String deleteAnalyst(Long id) {
        if (analystRepo.existsById(id)) {
            analystRepo.deleteById(id);
            return "Analyst deleted successfully";
        } else {
            return "Not found";
        }
    }

    
    @Override
    public String addObserver(Observer ob) {

        Observer saved = observerRepo.save(ob);

        // send email
        emailService.sendCredentials(
                saved.getEmail(),
                saved.getName(),
                saved.getPassword()
        );

        return "Observer added successfully & email sent";
    }

    
    @Override
    public String addAnalyst(Analyst an) {

        Analyst saved = analystRepo.save(an);

        // send email
        emailService.sendCredentials(
                saved.getEmail(),
                saved.getName(),
                saved.getPassword()
        );

        return "Analyst added successfully & email sent";
    }

    @Override
    public List<Issue> viewAllIssues() {
        return issuerepo.findAll();
    }
}