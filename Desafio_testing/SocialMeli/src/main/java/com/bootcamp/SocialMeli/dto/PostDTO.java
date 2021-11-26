package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Detail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {

    @Positive(message = "El id debe ser mayor a cero")
    @NotNull(message = "El campo no puede estar vacío")
    private Integer user_id;
    @Positive(message = "El id debe ser mayor a cero")
    @NotNull(message = "El campo no puede estar vacío")
    private Integer id_post;

    @NotNull(message = "El campo no puede estar vacío")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private DetailDTO detail;

    @Positive(message = "El id debe ser mayor a cero")
    @NotNull (message = "El campo no puede estar vacío")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000)
    @Positive(message = "El id debe ser mayor a cero")
    private Double price;
}
