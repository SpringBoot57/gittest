package com.example.posttracking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourierDto {
    private String trackingNumber;
    private Long clientId;
    private Long branchId;
    private LocalDateTime sentAt;
}
