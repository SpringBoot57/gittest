package com.example.aids.service;

import com.example.aids.entity.AuditLog;
import com.example.aids.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuditService {
    private final AuditLogRepository repository;

    public AuditService(AuditLogRepository repository) {
        this.repository = repository;
    }

    public void log(String endpoint, String request, String response, Long userId, Long docId, long responseTime) {
        AuditLog log = AuditLog.builder()
                .endpoint(endpoint)
                .request(request)
                .response(response)
                .userId(userId)
                .documentId(docId)
                .responseTimeMs(responseTime)
                .timestamp(Instant.now())
                .build();
        repository.save(log);
    }
}
