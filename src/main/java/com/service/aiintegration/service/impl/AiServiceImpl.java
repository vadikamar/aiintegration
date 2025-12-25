package com.service.aiintegration.service.impl;

import com.service.aiintegration.dto.ChatRequestDTO;
import com.service.aiintegration.dto.ChatResponseDTO;
import com.service.aiintegration.service.AiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AiServiceImpl implements AiService {
    private final Logger log = Logger.getLogger(AiServiceImpl.class.getName());
    @Value("${perplexity.api.key}")
    private String apiKey;

    @Value("${perplexity.api.url}")
    private String apiUrl;

    @Value("${perplexity.ai.model}")
    private String modelName;

    private final WebClient webClient = WebClient.create();

    public ChatResponseDTO askPerplexity(String userPrompt) {
        log.info("Starting service method to ask Perplexity API with prompt: " + userPrompt);
        ChatRequestDTO request = new ChatRequestDTO(
                modelName, // Perplexity model name
                List.of(new ChatRequestDTO.Message("user", userPrompt))
        );
        log.info("Constructed ChatRequestDTO: " + request);
        ChatResponseDTO response;
        try{
            response = webClient.post()
                    .uri(apiUrl)
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(ChatResponseDTO.class)
                    .block();
        }
        catch (Exception e){
            log.info("Exception occurred while calling Perplexity API: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.info("Service ends with ChatResponseDTO: " + response);
        return response;
    }
}
