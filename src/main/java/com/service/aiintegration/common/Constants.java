package com.service.aiintegration.common;

public class Constants {
    public static final Integer SUCCESS_STATUS = 200;
    public static final Integer POST_STATUS = 201;
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    public static final String MEMORY_SAVED_MESSAGE = "Memory saved successfully";
    public static final String MS_ID = "CMS";
    public static final Double NULL_CONFIDENCE_SCORE = 0.0;
    public static final Integer ZERO = 0;
    public static final Integer EIGHT = 8;
    public static final Integer LIMIT = 3;
    public static final String ROLE = "user";
    public static final String EMPTY = "";

    public static final String PROMPT_1 = """
                You are a helpful AI assistant. Use the context below to answer the question.
                
                Context:
                %s
                
                Question:
                %s
                """;
    private  Constants() {
        // private constructor to prevent instantiation
    }
}
