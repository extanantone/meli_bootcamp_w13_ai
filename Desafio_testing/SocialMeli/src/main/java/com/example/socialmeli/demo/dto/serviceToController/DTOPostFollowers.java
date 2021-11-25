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
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOPostFollowers {

    @NotNull(message = "El id del post no puede estar vacio")
    @Min(value = 0, message = "El id del post debe ser mayor a 0.")
    private int idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private DTOProduct detail;
    private int category;
    private double price;

}
