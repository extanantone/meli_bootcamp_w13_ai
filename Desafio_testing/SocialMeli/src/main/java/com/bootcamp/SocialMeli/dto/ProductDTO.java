package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDTO {

    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "El id debe ser mayor a 0")
    Integer product_id;
    @NotEmpty(message = "El campo no puede estar vacío")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[A-ZÀ-ÙÁ-ÚÄ-Üá-úä-üa-zà-ù0-9,.\\s]*$", message = "El campo no puede poseer caracteres especiales")
    String product_name;
    @NotEmpty(message = "El campo no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[A-ZÀ-ÙÁ-ÚÄ-Üá-úä-üa-zà-ù0-9,.\\s]*$", message = "El campo no puede poseer caracteres especiales")
    String type;
    @NotEmpty(message = "El campo no puede estar vacío")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^[A-ZÀ-ÙÁ-ÚÄ-Üá-úä-üa-zà-ù0-9,.\\s]*$", message = "El campo no puede poseer caracteres especiales")
    String brand;
    @NotEmpty(message = "El campo no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[A-ZÀ-ÙÁ-ÚÄ-Üá-úä-üa-zà-ù0-9,.\\s]*$", message = "El campo no puede poseer caracteres especiales")
    String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^[A-ZÀ-ÙÁ-ÚÄ-Üá-úä-üa-zà-ù0-9,.\\s]*$", message = "El campo no puede poseer caracteres especiales")
    String notes;
}
