package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ResponseDetailDTO> details;

    public ResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
}