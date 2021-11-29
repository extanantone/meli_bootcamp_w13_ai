package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    Integer user_id;
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    Integer id_post;
    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    String  date;
    @Valid
    ProductDTO detail;
    @NotNull(message = "El campo no puede estar vacío.")
    Integer category;
    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000.000", message = "El precio máximo por producto es de 10.000.000")
    Double price;
    
}
