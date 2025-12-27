package com.service.aiintegration.service;

import com.service.aiintegration.dto.ChatResponseDTO;

import java.util.List;

public interface AiService {
    /**
     * Ask Perplexity AI with a user prompt and get a response.
     *
     * @param userPrompt The user's prompt to send to Perplexity AI.
     * @return ChatResponseDTO containing the AI's response.
     */
    ChatResponseDTO askPerplexity(String userPrompt);
    /**
     * Generate an embedding vector for the given text.
     *
     * @param text The input text to generate an embedding for.
     * @return A Double array representing the embedding vector.
     */
    Double[] generateEmbedding(String text);
    /**
     * Ask a question using provided context documents.
     *
     * @param query The user's query.
     * @param contextDocs List of context documents to assist in answering the query.
     * @return The answer as a String.
     */
    String ask(String query, List<String> contextDocs);
    /**
     * Calculate the cosine similarity between two vectors.
     *
     * @param vec1 The first vector.
     * @param vec2 The second vector.
     * @return The cosine similarity as a double.
     */
    double cosineSimilarity(Double[] vec1, Double[]vec2);
}
