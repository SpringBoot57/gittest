package com.example.aids.controller;

import com.example.aids.entity.Document;
import com.example.aids.entity.User;
import com.example.aids.repository.UserRepository;
import com.example.aids.service.DocumentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final UserRepository userRepository;

    public DocumentController(DocumentService documentService, UserRepository userRepository) {
        this.documentService = documentService;
        this.userRepository = userRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<Long> upload(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("file") MultipartFile file) throws IOException {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        Document doc = documentService.saveDocument(file, user);
        return ResponseEntity.ok(doc.getId());
    }

}
