package com.example.aids.service;

import com.example.aids.entity.Document;
import com.example.aids.entity.Summary;
import com.example.aids.entity.User;
import com.example.aids.repository.SummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;

@Service
public class SummarizerService {

    private static final Logger log = LoggerFactory.getLogger(SummarizerService.class);
    private final WebClient webClient;
    private final SummaryRepository summaryRepository;
    private final DocumentService documentService;

    public SummarizerService(@Value("${openai.api.key}") String apiKey,
                             SummaryRepository summaryRepository,
                             DocumentService documentService) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
        this.summaryRepository = summaryRepository;
        this.documentService = documentService;
    }

    @Async
    @Cacheable("summaries")
    public void summarize(Document document, User user) {
        try {
            long start = System.currentTimeMillis();
            String text = documentService.extractText(document);
            String prompt = "Summarize the following text: " + text;
            String result = webClient.post()
                    .bodyValue("{" + "\"model\":\"gpt-3.5-turbo\"," +
                            "\"messages\":[{\"role\":\"system\",\"content\":\""+prompt.replace("\""," ")+"\"}]}")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Summary summary = Summary.builder()
                    .content(result)
                    .document(document)
                    .user(user)
                    .createdAt(Instant.now())
                    .build();
            summaryRepository.save(summary);
            log.info("summary created for user {} doc {} in {} ms", user.getId(), document.getId(), System.currentTimeMillis()-start);
        } catch (Exception e) {
            log.error("Error summarizing document", e);
        }
    }
}
