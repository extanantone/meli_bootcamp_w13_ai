package com.mercadolibre.socialmeli.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
    private String code;
    private String message;
}
