package com.bootcamp.socialmeliSprint1.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostInDTO {

    @NotNull(message = "No puede estar vacío.")
    @Positive(message = "Debe ser mayor a cero")
    private Integer userId;

    @NotNull(message = "No puede estar vacío.")
    @Positive(message = "Debe ser mayor a cero")
    private int IdPost;

    @NotNull(message = "No puede estar vacía.")
    private String date;

    private @Valid ProductInDTO detail;

    @NotNull(message = "No puede estar vacía.")
    private Integer category;

    @NotNull(message = "No puede estar vacío.")
    @DecimalMax(value = "10000000.00", message = "El precio máximo por producto es de 10000000.00")
    private Double price;

}
