package com.example.aids.service;

import com.example.aids.entity.Document;
import com.example.aids.entity.User;
import com.example.aids.repository.DocumentRepository;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final Path storagePath;
    private final Tika tika = new Tika();

    public DocumentService(DocumentRepository documentRepository, @Value("${app.file.storage-path}") String storagePath) throws IOException {
        this.documentRepository = documentRepository;
        this.storagePath = Paths.get(storagePath);
        Files.createDirectories(this.storagePath);
    }

    public Document saveDocument(MultipartFile file, User user) throws IOException {
        Path dest = this.storagePath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), dest);
        Document doc = Document.builder()
                .fileName(file.getOriginalFilename())
                .filePath(dest.toString())
                .user(user)
                .createdAt(Instant.now())
                .build();
        return documentRepository.save(doc);
    }

    public String extractText(Document document) throws IOException {
        return tika.parseToString(Paths.get(document.getFilePath()));
    }

    public Document findById(Long id) {
        return documentRepository.getReferenceById(id);
    }
}
