package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDTO {

    @NotNull (message = "La id no puede estar vacía.")
    @Positive (message = "El id debe ser mayor a cero.")
    private Integer userId;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Max(value = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp="^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.|\\s ]*$", message = "El campo no puede poseer caracteres especiales")
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<
            @NotNull(message = "La id no puede estar vacía")
            @Positive(message = "El id debe ser mayor a cero")
            Integer> followersId = new ArrayList<>();
}
