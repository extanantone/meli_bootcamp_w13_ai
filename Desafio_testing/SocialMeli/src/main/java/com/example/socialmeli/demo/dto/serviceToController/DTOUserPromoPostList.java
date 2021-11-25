package com.example.socialmeli.demo.dto.serviceToController;

import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOUserPromoPostList {

    @NotNull(message = "La id no puede estar vacia.")
    @Positive(message = "El id debe ser mayor a 0")
    private int userId;

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 15, message = "La longitud del nombre de la materia no puede superar los 15 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9]|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú)*", message = "El nombre posee caracteres invalidos")
    private String userName;

    private List<DTOPromoPost> posts = new ArrayList<>();


    public void addPostToList(DTOPromoPost p){

        posts.add(p);
    }

}
