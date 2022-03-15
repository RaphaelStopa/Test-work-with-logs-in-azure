package com.example.logs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(Object.class);

    @GetMapping()
    public ResponseEntity<String> getExample() {
        logger.info("Request received at the controller");
        return ResponseEntity.ok().body("log executed!");
    }
}
