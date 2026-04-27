package com.klef.sdp.sdpbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.sdp.sdpbackend.dto.FormData;
import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Citizen;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.security.JwtUtil;
import com.klef.sdp.sdpbackend.service.AdminService;
import com.klef.sdp.sdpbackend.service.AnalystService;
import com.klef.sdp.sdpbackend.service.CitizenService;
import com.klef.sdp.sdpbackend.service.ObserverService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authlogin")
@CrossOrigin("*")
public class LoginContoller {

    @Autowired
    private AdminService as;

    @Autowired
    private CitizenService cs;

    @Autowired
    private AnalystService an;

    @Autowired
    private ObserverService obs;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody FormData form) {

        String role = form.getRole();
        String username = form.getUsername();
        String password = form.getPassword();

        if (role.equalsIgnoreCase("ADMIN")) {
            Admin a = as.verifyAdminLogin(username, password);
            if (a != null) {
                String token = jwtUtil.generateToken(username, "ADMIN");

                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("role", "ADMIN");
                response.put("userId", a.getUsername());
                return ResponseEntity.ok(response);
            }
        }

        else if (role.equalsIgnoreCase("CITIZEN")) {
            Citizen c = cs.verifyCitizenLogin(username, password);
            if (c != null) {
                String token = jwtUtil.generateToken(username, "CITIZEN");

                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("role", "CITIZEN");
                response.put("userId", c.getId());
                return ResponseEntity.ok(response);
            }
        }

        else if (role.equalsIgnoreCase("OBSERVER")) {
            Observer ob = obs.verifyObserverLogin(username, password);
            if (ob != null) {
                String token = jwtUtil.generateToken(username, "OBSERVER");

                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("role", "OBSERVER");
                response.put("userId", ob.getId()); 
                return ResponseEntity.ok(response);
            }
        }

        
        else if (role.equalsIgnoreCase("ANALYST")) {
            Analyst a = an.verifyAnalystLogin(username, password);
            if (a != null) {
                String token = jwtUtil.generateToken(username, "ANALYST");

                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("role", "ANALYST");
                response.put("userId", a.getId());
                return ResponseEntity.ok(response);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}