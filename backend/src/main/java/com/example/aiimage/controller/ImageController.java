package com.example.aiimage.controller;

import com.example.aiimage.model.GenerationHistory;
import com.example.aiimage.repository.HistoryRepository;
import com.example.aiimage.service.ImageGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    @Autowired
    private ImageGenerationService imageGenerationService;

    @Autowired
    private HistoryRepository historyRepository;   // NEW

    @PostMapping("/generate")
    public ImageResponse generateImage(@RequestBody GenerateRequest request) {
        String imageUrl = imageGenerationService.generateImage(request.getPrompt());
        return new ImageResponse(imageUrl, request.getPrompt());
    }

    // NEW endpoint to get history
    @GetMapping("/history")
    public List<GenerationHistory> getHistory() {
        return historyRepository.findAllByOrderByCreatedAtDesc();
    }

    // Inner DTOs (unchanged)
    public static class GenerateRequest {
        private String prompt;
        public String getPrompt() { return prompt; }
        public void setPrompt(String prompt) { this.prompt = prompt; }
    }

    public static class ImageResponse {
        private String imageUrl;
        private String prompt;
        private long timestamp;
        public ImageResponse(String imageUrl, String prompt) {
            this.imageUrl = imageUrl;
            this.prompt = prompt;
            this.timestamp = System.currentTimeMillis();
        }
        public String getImageUrl() { return imageUrl; }
        public String getPrompt() { return prompt; }
        public long getTimestamp() { return timestamp; }
    }
}