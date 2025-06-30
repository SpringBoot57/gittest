package com.example.posttracking.service;

import com.example.posttracking.entity.RoleMenuPermission;
import com.example.posttracking.repository.RoleMenuPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleMenuPermissionService {
    private final RoleMenuPermissionRepository repository;

    public RoleMenuPermission save(RoleMenuPermission permission) {
        return repository.save(permission);
    }
}
