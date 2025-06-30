package com.example.posttracking.audit;

import com.example.posttracking.entity.AuditLog;
import com.example.posttracking.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AuditInterceptor implements HandlerInterceptor {

    private final AuditService auditService;

    private long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = null;
        if (auth != null && auth.getPrincipal() instanceof org.springframework.security.core.userdetails.User user) {
            // username is stored; fetch id not simple
        }
        AuditLog log = AuditLog.builder()
                .endpoint(request.getRequestURI())
                .userId(userId)
                .timestamp(LocalDateTime.now())
                .executionTimeMs(System.currentTimeMillis() - startTime)
                .build();
        auditService.save(log);
    }
}
