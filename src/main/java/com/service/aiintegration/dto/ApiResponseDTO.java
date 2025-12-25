package com.service.aiintegration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDTO<T> {
    private Integer status;
    private String message;
    private String msId;
    private T data;
}
