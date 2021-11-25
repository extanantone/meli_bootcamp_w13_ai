package com.example.socialmeli.demo.dto.controllerToService;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOProduct {

    @NotNull
    @Pattern(regexp="[0-9]+", message = "El id del producto debe ser tipo numero")
    private int productId;

private String productName;
private String type;
private String brand;
private String color;
private String notes;


}
