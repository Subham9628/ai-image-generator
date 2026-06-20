package com.example.aiimage.repository;

import com.example.aiimage.model.GenerationHistory;
import com.example.aiimage.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<GenerationHistory, Long> {
    List<GenerationHistory> findAllByOrderByCreatedAtDesc(); // if needed globally
    List<GenerationHistory> findByUserOrderByCreatedAtDesc(User user);
}