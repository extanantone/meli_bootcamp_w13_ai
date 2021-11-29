package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private int id;
    @NotBlank(message = "El nombre del usuario no puede estar vacio")
    @JsonProperty("user_name")
    private String name;
}
