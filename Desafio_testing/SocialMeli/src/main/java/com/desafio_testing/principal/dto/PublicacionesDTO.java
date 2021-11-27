package com.desafio_testing.principal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionesDTO implements Serializable {

    @Min(value=1 , message = "El id debe ser mayor a cero")
    @NotNull(message = "La id no puede estar vacía.")
    private Integer idPost;

    @Min(value=1, message = "El id debe ser mayor a cero")
    @NotNull(message = "La id no puede estar vacía.")
    private Integer userId;

    @JsonFormat(pattern = "dd-MM-yyyy")

    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    private @Valid ProductoDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @Size(max=13, message = "La longitud no puede superar los 13 caracteres.")
    @Pattern(regexp = "\\d{1,3}(\\.\\d{3})*(,\\d{1,2})?", message = "Número con el formato incorrecto")
    private String priceString;

    @DecimalMax(value = "10000000.00", message = "El precio máximo por producto es de 10.000.000")
    @DecimalMin(value = "0.00", message = "El precio mínimo por producto es de 0.00")
    @NotNull(message = "El campo no puede estar vacío.")
    private Double price;



    private Boolean hasPromo;

    @Max(value = 100)
    @Min(value = 0)
    private Double discount;
}
