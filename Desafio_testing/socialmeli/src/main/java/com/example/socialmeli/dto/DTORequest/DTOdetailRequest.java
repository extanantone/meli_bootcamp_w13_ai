package com.example.socialmeli.dto.DTORequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOdetailRequest {
    @NotNull(message = "La id no puede estar vacía.") @Min(value= 1, message = "El id debe ser mayor a cero")
    Integer product_id;
    @NotBlank(message = "El campo no puede estar vacío.")  @Size(max= 40,message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El campo no puede poseer caracteres especiales." )
    String product_name;
    @NotBlank(message = "El campo no puede estar vacío.")  @Size(max= 15,message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "El campo no puede poseer caracteres especiales." )
    String type;
    @NotBlank(message = "El campo no puede estar vacío.")  @Size(max= 25,message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "El campo no puede poseer caracteres especiales." )
    String brand;
    @NotBlank(message = "El campo no puede estar vacío.")  @Size(max= 15,message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "El campo no puede poseer caracteres especiales." )
    String color;
    @Size(max= 80,message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El campo no puede poseer caracteres especiales." )
    String notes;
}
