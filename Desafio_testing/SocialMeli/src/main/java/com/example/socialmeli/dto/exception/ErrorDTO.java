package com.example.socialmeli.dto.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO
{
    private String name;
    private String description;
    private List<String> errors;

    public ErrorDTO(String name, String description, List<String> errors)
    {
        this.name = name;
        this.description = description;
        this.errors = errors;
    }

    public ErrorDTO(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
}
