package com.service.aiintegration.service;

import com.service.aiintegration.dto.ChatResponseDTO;

public interface AiService {
    ChatResponseDTO askPerplexity(String userPrompt);
}
