package com.example.socialmeli.dto.DTORequest;

import com.example.socialmeli.Models.DetalleProduct;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOproductsRequest {
    @NotNull(message = "La id no puede estar vacía.") @Min(value= 1, message = "El id debe ser mayor a cero")
    Integer user_id;
    @NotNull(message = "La id no puede estar vacía.") @Min(value= 1, message = "El id debe ser mayor a cero")
    Integer id_post;
    @NotNull(message = "La fecha no puede estar vacía.")  @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    @Valid
    DTOdetailRequest detail;
    @NotNull(message = "El campo no puede estar vacío.")
    Integer category;
    @NotNull(message = "El campo no puede estar vacío.") @Max(value = 1000000, message = "El precio máximo por producto es de 10.000.000")
    double price;
    Boolean has_promo;
    double discount;

    public DTOproductsRequest(Integer user_id, Integer id_post, LocalDate date, DTOdetailRequest detail, Integer category, double price) {
        this.user_id = user_id;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
