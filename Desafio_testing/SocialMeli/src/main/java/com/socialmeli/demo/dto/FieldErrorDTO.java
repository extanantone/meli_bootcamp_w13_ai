package com.socialmeli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class FieldErrorDTO {

    private final String path;
    private  final String message;
}
