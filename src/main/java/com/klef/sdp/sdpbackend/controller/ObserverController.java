package com.klef.sdp.sdpbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.entity.Report;
import com.klef.sdp.sdpbackend.service.ObserverService;

@RestController
@RequestMapping("/observerapi")
@CrossOrigin("*")
public class ObserverController {

    @Autowired
    private ObserverService observerservice;

    @GetMapping("/")
    public String observerhome() {
        return "Observer Controller Demo";
    }

    @PostMapping("/login")
    public ResponseEntity<?> verifyObserverlogin(@RequestBody Observer observer) {
        try 
        {
            Observer o = observerservice.verifyObserverLogin(observer.getEmail(),observer.getPassword());

            if (o != null) 
            {
                return ResponseEntity.status(200).body(o);
            } 
            else 
            {
                return ResponseEntity.status(401).body("Login Invalid");
            }
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @PostMapping("/addreport")
    public ResponseEntity<?> addReport(@RequestBody Report report) 
    {
        try 
        {
            Report r = observerservice.addReport(report);
            return ResponseEntity.status(200).body(r);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Error adding report");
        }
    }

    @GetMapping("/reports/{observerId}")
    public ResponseEntity<?> getReports(@PathVariable Long observerId) 
    {
        try 
        {
            List<Report> list = observerservice.getReportsByObserver(observerId);
            return ResponseEntity.status(200).body(list);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Error fetching reports");
        }
    }
    @GetMapping("/totalreports")
    public ResponseEntity<?> getTotalReports() 
    {
        try 
        {
            long count = observerservice.totalReports();
            return ResponseEntity.status(200).body(count);
        }
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Error fetching total reports");
        }
    }

    @PostMapping("/report/update/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,@RequestParam String status) 
    {
        try 
        {
            Report r = observerservice.updateReportStatus(id, status);
            return ResponseEntity.status(200).body(r);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Error updating status");
        }
    }

    @GetMapping("/summary/{observerId}")
    public ResponseEntity<?> getSummary(@PathVariable Long observerId) 
    {
        try 
        {
            Map<String, Long> map = new HashMap<>();

            map.put("total", observerservice.totalReportsByObserver(observerId));
            map.put("pending", observerservice.countByStatusAndObserver("PENDING", observerId));
            map.put("resolved", observerservice.countByStatusAndObserver("RESOLVED", observerId));

            return ResponseEntity.status(200).body(map);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Error fetching summary");
        }
    }
    
    @GetMapping("/reports/location/{location}")
    public ResponseEntity<?> getReportsByLocation(@PathVariable String location) 
    {
        try 
        {
            List<Report> list = observerservice.getReportsByLocation(location);
            return ResponseEntity.status(200).body(list);
        }
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Error fetching reports by location");
        }
    }
}