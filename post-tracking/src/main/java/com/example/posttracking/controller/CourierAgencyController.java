package com.example.posttracking.controller;

import com.example.posttracking.entity.CourierAgency;
import com.example.posttracking.service.CourierAgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courier-agencies")
@RequiredArgsConstructor
public class CourierAgencyController {
    private final CourierAgencyService service;

    @GetMapping
    public ResponseEntity<List<CourierAgency>> list() {
        return ResponseEntity.ok(service.findAll());
    }
}
