package com.example.aids.service;

import com.example.aids.dto.SummaryDto;
import com.example.aids.entity.Summary;
import com.example.aids.entity.User;
import com.example.aids.repository.SummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryService {

    private final SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public List<SummaryDto> getSummaries(User user) {
        return summaryRepository.findByUser(user).stream()
                .map(s -> new SummaryDto(s.getDocument().getId(), s.getDocument().getFileName(), s.getContent()))
                .collect(Collectors.toList());
    }
}
