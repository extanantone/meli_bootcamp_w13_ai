package com.example.socialmeli.demo.dto.serviceToController;

import com.example.socialmeli.demo.dto.controllerToService.DTOProduct;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOPostFollowers {

    @NotNull(message = "La id no puede estar vacia.")
    @Positive(message = "El id debe ser mayor a 0")
    private int idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha de publicación no puede estar vacia.")
    private LocalDate date;
    private DTOProduct detail;
    private int category;
    private double price;

}
