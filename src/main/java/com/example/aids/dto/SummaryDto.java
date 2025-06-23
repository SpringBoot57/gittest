package com.example.aids.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SummaryDto {
    private Long documentId;
    private String documentName;
    private String content;
}
