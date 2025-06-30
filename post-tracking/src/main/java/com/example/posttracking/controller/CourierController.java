package com.example.posttracking.controller;

import com.example.posttracking.dto.CourierDto;
import com.example.posttracking.entity.Courier;
import com.example.posttracking.service.CourierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @PostMapping
    public ResponseEntity<Courier> create(@Valid @RequestBody CourierDto dto) {
        return ResponseEntity.ok(courierService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Page<Courier>> list(Pageable pageable) {
        return ResponseEntity.ok(courierService.list(pageable));
    }
}
