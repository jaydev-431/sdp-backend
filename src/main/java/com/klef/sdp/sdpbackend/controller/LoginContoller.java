package com.klef.sdp.sdpbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klef.sdp.sdpbackend.dto.FormData;
import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.service.AdminService;
import com.klef.sdp.sdpbackend.service.AnalystService;
import com.klef.sdp.sdpbackend.service.CitizenService;
import com.klef.sdp.sdpbackend.service.ObserverService;

@RestController
@RequestMapping("/authlogin")
@CrossOrigin("*")
public class LoginContoller {
	@Autowired
	public AdminService as ;
	
	@Autowired
	public CitizenService cs;
	
	@Autowired
	public AnalystService an;
	
	@Autowired
	public ObserverService obs;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody FormData form){
		String role = form.getRole();
		if(role.equalsIgnoreCase("ADMIN")) {
			Admin a = as.verifyAdminLogin(form.getUsername(), form.getPassword());
			if(a!=null) {
				return ResponseEntity.ok(a);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid Credentials");
			}
		}else if(role.equalsIgnoreCase("Citizen")){
			Citizen c = cs.verifyCitizenLogin(form.getUsername(), form.getPassword());
			if(c!=null) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid Credentials");
			}
		}else if(role.equalsIgnoreCase("observer")) {
			Observer ob = obs.verifyObserverLogin(form.getUsername(), form.getPassword());
			if(ob!=null){
				return ResponseEntity.ok(ob);
			}else {
				return ResponseEntity.status(401).body("Invalid credentials");
			}
		}else {
			Analyst a = an.verifyAnalystLogin(form.getUsername(), form.getPassword());
			if(a!=null) {
				return ResponseEntity.ok(a);
			}else {
				return ResponseEntity.status(401).body("Invalid credentials");
			}
		}
	}
}
