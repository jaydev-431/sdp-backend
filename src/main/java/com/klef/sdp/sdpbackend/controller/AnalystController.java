package com.klef.sdp.sdpbackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.service.AnalystService;

@RestController
@RequestMapping("/analystapi")
@CrossOrigin("*")   
public class AnalystController {

    private final AnalystService analystService;

    public AnalystController(AnalystService analystService) {
        this.analystService = analystService;
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {

        Analyst analyst = analystService.verifyAnalystLogin(
                data.get("email"),
                data.get("password")
        );

        if (analyst != null) {
            return ResponseEntity.ok(analyst);
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    // VIEW ALL ISSUES
    @GetMapping("/viewallissues")
    public ResponseEntity<List<Issue>> getAllIssues() {
        return ResponseEntity.ok(analystService.getAllIssues());
    }

    // GET ISSUES BY REGION
    @GetMapping("/pollingstation/{pollingstation}")
    public ResponseEntity<List<Issue>> getByPollingStation(@PathVariable String pollingstation) {
        return ResponseEntity.ok(analystService.getIssuesByPollingstation(pollingstation));
    }

    // UPDATE ISSUE STATUS
    @PutMapping("/updateIssueStatus/{id}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @PathVariable String status) {

        Issue issue = analystService.updateIssueStatus(id, status);

        if (issue != null) {
            return ResponseEntity.ok(issue);
        } else {
            return ResponseEntity.status(404).body("Issue not found");
        }
    }

    // REPORT
    @GetMapping("/report")
    public ResponseEntity<String> getReport() {
        return ResponseEntity.ok(analystService.generateReport());
    }
}