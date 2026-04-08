package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.klef.sdp.sdpbackend.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{
		Admin findByUsernameAndPassword(String username , String password) ;
		
		
		
}
