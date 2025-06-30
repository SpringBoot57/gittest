package com.example.posttracking.service;

import com.example.posttracking.entity.CourierAgency;
import com.example.posttracking.repository.CourierAgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierAgencyService {
    private final CourierAgencyRepository repository;

    public List<CourierAgency> findAll() {
        return repository.findAll();
    }
}
