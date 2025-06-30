package com.example.posttracking.service;

import com.example.posttracking.dto.CourierDto;
import com.example.posttracking.entity.Client;
import com.example.posttracking.entity.Courier;
import com.example.posttracking.entity.CourierBranch;
import com.example.posttracking.repository.ClientRepository;
import com.example.posttracking.repository.CourierBranchRepository;
import com.example.posttracking.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;
    private final ClientRepository clientRepository;
    private final CourierBranchRepository branchRepository;

    @Transactional
    public Courier create(CourierDto dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
        CourierBranch branch = branchRepository.findById(dto.getBranchId()).orElseThrow();
        Courier courier = Courier.builder()
                .trackingNumber(dto.getTrackingNumber())
                .client(client)
                .branch(branch)
                .sentAt(dto.getSentAt())
                .build();
        return courierRepository.save(courier);
    }

    public Page<Courier> list(Pageable pageable) {
        return courierRepository.findAll(pageable);
    }
}
