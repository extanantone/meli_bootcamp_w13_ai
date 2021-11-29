package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDTO {

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "La id debe ser mayor a cero.")
    private Integer userId;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|" +
            "|á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|" +
            "Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z",
            message = "El campo no puede poseer caracteres especiales.")
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private List<Integer> followersId = new ArrayList<>();
}
