package com.klef.sdp.sdpbackend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Discussion;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.service.CitizenService;

@RestController
@RequestMapping("citizen_api")
@CrossOrigin("*")
public class CitizenController {
	
	@Autowired
	public CitizenService citizenservice;
	
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<?> verifyLogin(@RequestBody Citizen citizen ) {
		try {
			Citizen c = citizenservice.verifyCitizenLogin(citizen.getEmail(), citizen.getPassword());
				if(c!=null) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.status(401).body("Login invalid");
				}
			
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}
	
	@PostMapping("/citizenregister")
	public ResponseEntity<?> signUp(@RequestBody Citizen c){
		try {
			citizenservice.CitizenRegister(c);
			return ResponseEntity.ok("account created successfully");
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Server error");
		}
	}
	
	@PostMapping("addissue")
	public ResponseEntity<?> addIssue(@RequestBody Issue i){
		try {
			String value = citizenservice.addIssue(i);
			return ResponseEntity.ok(value);
		}catch(Exception e) {
			return ResponseEntity.status(500).body("failed to add");
		}
	}
	
	@PostMapping("/addDiscussion")
	public ResponseEntity<String> addDiscussion(@RequestBody Discussion d) {
		String value = citizenservice.addDiscussion(d);
		return ResponseEntity.status(200).body(value);
	}
	
	@GetMapping("/viewalldiscussions")
	public ResponseEntity<?> viewAllDiscussions(){
		List<Discussion> d = citizenservice.viewDiscussions();
		if(d.size()>0) {
			return ResponseEntity.ok(d);
		}else {
			return ResponseEntity.status(204).body("No messages yet;");
		}
	
	}
	
	
	@GetMapping("/viewmyissues") 
	public ResponseEntity<?> viewMyIssues(){
		List<Issue> i = citizenservice.viewMyIssues();
		if(i.size()>0) {
			return ResponseEntity.ok(i);
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No issues");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
