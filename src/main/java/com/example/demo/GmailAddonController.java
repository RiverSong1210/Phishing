package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GmailAddonController {

    @PostMapping("/received")
    public String receiveRequest() {
        return "I got an answer!";
    }
}

