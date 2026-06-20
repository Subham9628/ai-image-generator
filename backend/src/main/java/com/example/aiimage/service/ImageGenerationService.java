package com.example.aiimage.service;

import com.example.aiimage.model.GenerationHistory;
import com.example.aiimage.model.User;
import com.example.aiimage.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class ImageGenerationService {

    @Autowired
    private HistoryRepository historyRepository;   // NEW
        public String generateImage(String prompt, User user) {
        	 String encodedPrompt = URLEncoder.encode(prompt, StandardCharsets.UTF_8);
             String imageUrl = "https://image.pollinations.ai/prompt/" + encodedPrompt 
                              + "?width=1024&height=1024&seed=" + System.currentTimeMillis();// same as before

            GenerationHistory history = new GenerationHistory();
            history.setPrompt(prompt);
            history.setImageUrl(imageUrl);
            history.setUser(user); // set the user
            history.setCreatedAt(LocalDateTime.now());
            historyRepository.save(history);

            return imageUrl;
        }
    }
