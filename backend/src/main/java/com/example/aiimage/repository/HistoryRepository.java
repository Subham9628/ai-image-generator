package com.example.aiimage.repository;

import com.example.aiimage.model.GenerationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<GenerationHistory, Long> {
    // Find all history, ordered by creation time (most recent first)
    List<GenerationHistory> findAllByOrderByCreatedAtDesc();

    // Optional: find by userId (for later when we add auth)
    List<GenerationHistory> findByUserIdOrderByCreatedAtDesc(String userId);
}