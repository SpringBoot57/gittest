package com.example.posttracking.service;

import com.example.posttracking.entity.Role;
import com.example.posttracking.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    @Cacheable("roles")
    public List<Role> findAll() {
        return repository.findAll();
    }
}
