package com.example.socialmeli.demo.dto.controllerToService;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTORequestPostsFromFolloweds {

    @NotNull(message = "La id no puede estar vacia.")
    @Positive(message = "El id debe ser mayor a 0")
    private int userId;

    private String order;

}
