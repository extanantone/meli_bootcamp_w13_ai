package SocialMeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {

    @Positive(message = "Debe ser un entero positivo")
    int productId;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\\s]+$" ,message="El campo no puede poseer caracteres especiales")
    String productName;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ]+$" ,message="El campo no puede poseer caracteres especiales")
    String type;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ]+$" ,message="El campo no puede poseer caracteres especiales")
    String brand;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ]+$" ,message="El campo no puede poseer caracteres especiales")
    String color;

    @Size(max = 80, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^(?:[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\\s]|)+$" ,message="El campo no puede poseer caracteres especiales")
    String notes;

}
