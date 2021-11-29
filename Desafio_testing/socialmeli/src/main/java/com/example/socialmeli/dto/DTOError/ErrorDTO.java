package com.example.socialmeli.dto.DTOError;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonSerialize
@ToString
@Setter @Getter
public class ErrorDTO {
    String message;
    Integer error;

    public ErrorDTO(String message, Integer error) {
        this.message = message;
        this.error = error;
    }
}
