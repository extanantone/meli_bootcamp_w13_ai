package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDTO {

    @NotNull(message = "La id del usuario no puede estar vacía")
    @Positive(message = "La id del usuario no puede ser negativa")
    @JsonProperty("user_id")
    private Long userID;
    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @NotNull(message = "El campo no puede estar vacío.")
    @Valid
    private ProductDTO detail;
    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacío.")
    @Min(value = 0, message = "El precio minimo por producto es de 0")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @Positive(message = "El valor del descuento debe ser mayor a 0")
    private Double discount;
}
