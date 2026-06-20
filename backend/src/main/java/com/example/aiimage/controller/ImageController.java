package com.example.aiimage.controller;

import com.example.aiimage.model.GenerationHistory;
import com.example.aiimage.model.User;
import com.example.aiimage.repository.HistoryRepository;
import com.example.aiimage.service.ImageGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    @Autowired
    private ImageGenerationService imageService;
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/generate")
    public ImageResponse generateImage(@RequestBody GenerateRequest request,
                                       @AuthenticationPrincipal User user) {
        String imageUrl = imageService.generateImage(request.getPrompt(), user);
        return new ImageResponse(imageUrl, request.getPrompt());
    }

    @GetMapping("/history")
    public List<GenerationHistory> getHistory(@AuthenticationPrincipal User user) {
        return historyRepository.findByUserOrderByCreatedAtDesc(user);
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