package com.example.posttracking.service;

import com.example.posttracking.entity.CourierBranch;
import com.example.posttracking.repository.CourierBranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierBranchService {
    private final CourierBranchRepository repository;

    public List<CourierBranch> findAll() {
        return repository.findAll();
    }
}
