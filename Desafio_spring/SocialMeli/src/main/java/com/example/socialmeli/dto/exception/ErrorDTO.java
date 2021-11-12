package com.example.socialmeli.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO
{
    private String name;
    private String description;
}
