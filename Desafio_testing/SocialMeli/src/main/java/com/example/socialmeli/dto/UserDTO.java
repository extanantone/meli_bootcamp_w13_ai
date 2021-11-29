package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class UserDTO {

    @NotNull(message = "user_id no puede ser nula")
    @Positive(message = "user_id debe ser positivo")
    private Integer userId;

    @NotBlank(message = "user_name no puede ser nulo")
    @Size(max = 15, message = "user_name debe tener como maximo 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "user_name solo puede contener letras y numeros")
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> followersId = new ArrayList<>();
}
