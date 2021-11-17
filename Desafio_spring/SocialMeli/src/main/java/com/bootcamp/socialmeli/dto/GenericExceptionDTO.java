package com.bootcamp.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericExceptionDTO {
    private Integer errorCode;
    private String errorMessage;
}
