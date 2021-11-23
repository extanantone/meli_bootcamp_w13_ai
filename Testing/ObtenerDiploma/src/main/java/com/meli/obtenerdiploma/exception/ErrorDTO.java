package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ErrorDTO {
    private String tipo;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, List<String>> errorFields;
}
