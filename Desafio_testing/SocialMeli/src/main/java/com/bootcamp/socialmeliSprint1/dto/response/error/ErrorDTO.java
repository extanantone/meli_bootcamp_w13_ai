package com.bootcamp.socialmeliSprint1.dto.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String code;
    private String message;

    @JsonInclude
    private HashMap<String, List<String>> errors;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
}