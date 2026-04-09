package com.klef.sdp.sdpbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.service.AnalystService;

@RestController
@RequestMapping("/analystapi")
@CrossOrigin("*")
public class AnalystController {

	@Autowired
	private AnalystService analystservice;
	
	@GetMapping("/")
	 public String analysthome()
	  {
		   return "Analyst Controller Demo";
	  }
	
	@PostMapping("/login")
	 public ResponseEntity<?> verifyAnalystlogin(@RequestBody Analyst analyst)
	  {
		   try
			{
				Analyst a = analystservice.verifyAnalystLogin(analyst.getEmail(), analyst.getPassword());
			
			    if(a!=null)
			    {
			    	return ResponseEntity.status(200).body(a);
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
}
