package com.example.aids.controller;

import com.example.aids.entity.Document;
import com.example.aids.entity.User;
import com.example.aids.repository.UserRepository;
import com.example.aids.service.DocumentService;
import com.example.aids.service.SummarizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summarize")
public class SummarizerController {

    private final SummarizerService summarizerService;
    private final DocumentService documentService;
    private final UserRepository userRepository;

    public SummarizerController(SummarizerService summarizerService, DocumentService documentService, UserRepository userRepository) {
        this.summarizerService = summarizerService;
        this.documentService = documentService;
        this.userRepository = userRepository;
    }

    @PostMapping("/{docId}")
    public ResponseEntity<String> summarize(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long docId) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        Document doc = documentService.findById(docId);
        summarizerService.summarize(doc, user);
        return ResponseEntity.ok("Summarization started");
    }
}
