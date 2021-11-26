package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    String code;
    String message;
    List<ValidFieldErrorDTO> validList;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
