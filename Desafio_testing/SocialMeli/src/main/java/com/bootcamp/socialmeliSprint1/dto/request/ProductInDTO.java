package com.bootcamp.socialmeliSprint1.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductInDTO {

    @NotNull(message = "No puede estar vacío.")
    @Positive(message = "Debe ser mayor a cero")
    private Integer productId;

    @NotEmpty(message = "No puede estar vacío.")
    @Size(max = 40 , min = 1, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "No Debe contener caracteres especiales")
    private String productName;

    @NotEmpty(message = "No puede estar vacío.")
    @Size(max = 15, min = 1, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "No Debe contener caracteres especiales")
    private String type;

    @NotEmpty(message = "No puede estar vacío.")
    @Size(max = 25 , min = 1, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "No Debe contener caracteres especiales")
    private String brand;

    @NotEmpty(message = "No puede estar vacío.")
    @Size(max = 15, min = 1, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "No Debe contener caracteres especiales")
    private String color;

    @JsonInclude
    @Size(max = 80, min = 1, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "No Debe contener caracteres especiales")
    private String notes;
}
