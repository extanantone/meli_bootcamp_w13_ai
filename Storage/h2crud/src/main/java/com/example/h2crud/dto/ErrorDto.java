package com.example.h2crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {

    String name;
    String message;
    HashMap<String, List<String>> errorFields;
}
