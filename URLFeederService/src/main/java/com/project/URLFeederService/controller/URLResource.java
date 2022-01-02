package com.project.URLFeederService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url-resource")
public class URLResource {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/post-url")
    public ResponseEntity<Void> sendURL(@RequestBody String url) {
        System.out.println(url);
        return ResponseEntity.ok().build();
    }
}
