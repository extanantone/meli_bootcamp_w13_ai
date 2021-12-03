package com.example.h2crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentCreateResponseDto {
    private String message;
    private Long id;
}
