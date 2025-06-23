package com.example.aids.controller;

import com.example.aids.dto.SummaryDto;
import com.example.aids.entity.User;
import com.example.aids.repository.UserRepository;
import com.example.aids.service.SummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/summaries")
public class SummaryController {

    private final SummaryService summaryService;
    private final UserRepository userRepository;

    public SummaryController(SummaryService summaryService, UserRepository userRepository) {
        this.summaryService = summaryService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<SummaryDto>> list(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(summaryService.getSummaries(user));
    }
}
