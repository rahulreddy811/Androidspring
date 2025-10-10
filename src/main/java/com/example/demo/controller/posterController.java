package com.example.demo.controller;

import com.example.demo.service.TMDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class posterController {
    @Autowired
    private TMDbService tmDbService;

    @GetMapping("/posters")
    public List<String> getPosterUrls() {
        return tmDbService.getPosterUrls();
    }
}
