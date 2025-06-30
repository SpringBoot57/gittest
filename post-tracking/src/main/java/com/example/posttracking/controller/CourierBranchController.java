package com.example.posttracking.controller;

import com.example.posttracking.entity.CourierBranch;
import com.example.posttracking.service.CourierBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courier-branches")
@RequiredArgsConstructor
public class CourierBranchController {
    private final CourierBranchService service;

    @GetMapping
    public ResponseEntity<List<CourierBranch>> list() {
        return ResponseEntity.ok(service.findAll());
    }
}
