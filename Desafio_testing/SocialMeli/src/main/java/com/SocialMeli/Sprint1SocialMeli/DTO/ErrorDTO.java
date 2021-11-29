package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorDTO {
    String code;
    String mensaje;
  List<ValidFieldErrorDTO> errorFields;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.mensaje = message;
        this.errorFields = new ArrayList<>();
    }
}