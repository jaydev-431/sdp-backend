package com.klef.sdp.sdpbackend.controller;

import java.util.List;

import org.apache.logging.log4j.status.StatusConsoleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.service.AdminService;
import com.klef.sdp.sdpbackend.service.AnalystService;
import com.klef.sdp.sdpbackend.service.ObserverService;

@RestController
@RequestMapping("/admin_api")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	public AdminService adminservice;
	
	@Autowired 
	public ObserverService observerService;
	
	@Autowired
	public AnalystService as;

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Home() {
		return "SDP Backend project ";
	}
	
	@RequestMapping(path="/verifyadminlogin",method=RequestMethod.POST)
	public ResponseEntity<?> verifyAdminLogin(@RequestBody Admin a) {
		try {
		Admin ad = adminservice.verifyAdminLogin(a.getUsername(), a.getPassword());
		if(ad!=null) {
			return ResponseEntity.status(201).body(a);			
		}else {
			return ResponseEntity.status(401).body("Invalid login");
		}
	}catch(Exception e) {
		return ResponseEntity.status(500).body("Internal Server error");
	}
	}
	
	@RequestMapping(value="/viewallobservers",method=RequestMethod.GET)
	public ResponseEntity<?> viewAllObservers(){
		try {
		List<Observer> list = adminservice.viewAllObservers();
		return ResponseEntity.ok(list);
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Internal Server error");
		}
		
	}
	
	
	
	@GetMapping("/viewallanalysts")
	public ResponseEntity<?> viewAllanAnalysts(@RequestBody Analyst an){
		try {
			List<Analyst> alist= adminservice.viewAllAnalysts();
			if(alist.size()>0) {
				
				return ResponseEntity.ok(alist);
			}
			return ResponseEntity.noContent().build();
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Error fetching analysts");
		}
	}
	
	@PostMapping("/addanalyst")
	public ResponseEntity<?> addAnalyst(@RequestBody Analyst an){
		try {
		String value = adminservice.addAnalyst(an);
		return ResponseEntity.ok("Analyst added");
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Internal server error");
		}
	}
	
	
	
	
}
