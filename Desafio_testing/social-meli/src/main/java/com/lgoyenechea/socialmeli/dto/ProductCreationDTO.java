package com.lgoyenechea.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductCreationDTO {

    @NotEmpty(message = "{string.notempty}")
    @Size(max = 40, message = "{string.size.max.value.forty}")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "{string.specialcharacters}")
    private String productName;

    @NotEmpty(message = "{string.notempty}")
    @Size(max = 15, message = "{string.size.max.value.fifteen}")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "{string.specialcharacters}")
    private String type;

    @NotEmpty(message = "{string.notempty}")
    @Size(max = 25, message = "{string.size.max.value.twentyfive}")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "{string.specialcharacters}")
    private String brand;

    @NotEmpty(message = "{string.notempty}")
    @Size(max = 15, message = "{string.size.max.value.fifteen}")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "{string.specialcharacters}")
    private String color;

    @Size(max = 80, message = "{string.size.max.value.eighty}")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "{string.specialcharacters}")
    private String notes;
}
