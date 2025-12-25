package com.service.aiintegration.controller;

import com.service.aiintegration.dto.ApiResponseDTO;
import com.service.aiintegration.dto.ChatResponseDTO;
import com.service.aiintegration.service.AiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final AiService aiService;
    private final Logger log = Logger.getLogger(AiController.class.getName());
    @GetMapping("/chat")
    public ResponseEntity<ApiResponseDTO<ChatResponseDTO>> chat(@RequestParam String prompt) {
        log.info("Starting controller method for /chat endpoint for prompt: " + prompt);
        ChatResponseDTO response = aiService.askPerplexity(prompt);
        log.info("Ending controller with Response from AiController: " + response);
        return ResponseEntity.ok(new ApiResponseDTO<>(200, "Success", "CMS", response));
    }
}
