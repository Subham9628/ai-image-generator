package com.example.aiimage.service;

import com.example.aiimage.model.GenerationHistory;
import com.example.aiimage.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class ImageGenerationService {

    @Autowired
    private HistoryRepository historyRepository;   // NEW

    public String generateImage(String prompt) {
        String encodedPrompt = URLEncoder.encode(prompt, StandardCharsets.UTF_8);
        String imageUrl = "https://image.pollinations.ai/prompt/" + encodedPrompt 
                         + "?width=1024&height=1024&seed=" + System.currentTimeMillis();
        
        // --- NEW: Save to database ---
        GenerationHistory history = new GenerationHistory(prompt, imageUrl, "anonymous");
        historyRepository.save(history);
        System.out.println("✅ Saved generation to history: " + prompt);
        
        return imageUrl;
    }
}