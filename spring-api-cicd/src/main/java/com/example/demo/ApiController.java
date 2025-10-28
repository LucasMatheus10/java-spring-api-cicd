package com.example.demo;

import java.time.Instant;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye, World!";
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("status", "ok",
                      "name", "Simple API",
                      "timestamp", Instant.now().toString());
    }
    
}
