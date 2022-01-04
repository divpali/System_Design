package com.project.URLFeederService.controller;

import com.project.URLFeederService.constant.Constants;
import com.project.URLFeederService.model.URLEntity;
import com.project.URLFeederService.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
@RequestMapping("/url-resource")
public class URLResource {

    @Autowired
    private URLService urlService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/post-url")
    public ResponseEntity<Void> sendURL(@RequestBody URLEntity url) {
        url.setId(Constants.URL_UUID_PREFIX +UUID.randomUUID().toString());
        url.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        urlService.save(url);
        System.out.println(url);
        return ResponseEntity.ok().build();
    }
}
