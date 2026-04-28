package com.klef.sdp.sdpbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/authlogin")
    public String test() {
        return "Auth endpoint working";
    }
}