package com.meli.obtenerdiploma.model;


import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String name;
    private String description;
}
