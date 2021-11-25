package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "La id debe mayor a cero")
    private Integer userId;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Max(value = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ]*$", message = "El campo no puede poseer caracteres especiales")
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<
            @NotNull(message = "La id no puede estar vacía")
            @Positive(message = "La id debe mayor a cero")
                    Integer> followersId = new ArrayList<>();
}
