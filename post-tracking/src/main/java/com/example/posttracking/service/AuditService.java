package com.example.posttracking.service;

import com.example.posttracking.entity.AuditLog;
import com.example.posttracking.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditLogRepository auditLogRepository;

    public void save(AuditLog log) {
        auditLogRepository.save(log);
    }
}
