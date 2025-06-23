package com.example.aids.repository;

import com.example.aids.entity.Summary;
import com.example.aids.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    List<Summary> findByUser(User user);
}
