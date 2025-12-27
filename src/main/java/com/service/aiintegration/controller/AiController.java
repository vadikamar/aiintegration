package com.service.aiintegration.controller;

import com.service.aiintegration.common.Constants;
import com.service.aiintegration.dto.ApiResponseDTO;
import com.service.aiintegration.dto.ChatResponseDTO;
import com.service.aiintegration.entity.Memory;
import com.service.aiintegration.service.AiService;
import com.service.aiintegration.service.RagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ai")
/** * Controller class to handle AI-related endpoints.
 */
public class AiController {
    private final AiService aiService;
    private final RagService ragService;
    private final Logger log = Logger.getLogger(AiController.class.getName());
    /**
     * Endpoint to handle chat requests.
     * @param prompt The user's prompt.
     * @return ResponseEntity containing the chat response.
     */
    @GetMapping("/chat")
    public ResponseEntity<ApiResponseDTO<ChatResponseDTO>> chat(@RequestParam String prompt) {
        log.info("Starting controller method for /chat endpoint for prompt: " + prompt);
        ChatResponseDTO response = aiService.askPerplexity(prompt);
        log.info("Ending controller with Response from AiController: " + response);
        return ResponseEntity.ok(new ApiResponseDTO<>(Constants.SUCCESS_STATUS, Constants.SUCCESS_MESSAGE, Constants.MS_ID, response));
    }
    /**
     * Endpoint to add memory.
     * @param type The type of memory.
     * @param key The key for the memory.
     * @param value The value of the memory.
     * @return ResponseEntity containing the saved memory.
     */
    @PostMapping("/memory")
    public ResponseEntity<ApiResponseDTO<Memory>> addMemory(@RequestParam String type,
                            @RequestParam String key,
                            @RequestParam String value) {
        log.info("Starting controller Adding memory with type: " + type + ", key: " + key + ", value: " + value);
        Memory memory = ragService.saveMemory(type, key, value);
        log.info("Ending controller Adding memory with Response: " + memory);
        return ResponseEntity.ok(new ApiResponseDTO<>(Constants.POST_STATUS, Constants.MEMORY_SAVED_MESSAGE, Constants.MS_ID, memory));
    }
    /**
     * Endpoint to query using RAG.
     * @param text The user's query text.
     * @return ResponseEntity containing the RAG response.
     */
    @GetMapping("/query")
    public ResponseEntity<ApiResponseDTO<String>> query(@RequestParam String text) {
        log.info("Starting controller method for /query endpoint for text: " + text);
        String response = ragService.query(text);
        log.info("Ending controller with Response from AiController: " + response);
        return ResponseEntity.ok(new ApiResponseDTO<>(Constants.SUCCESS_STATUS, Constants.SUCCESS_MESSAGE, Constants.MS_ID, response));
    }
}
