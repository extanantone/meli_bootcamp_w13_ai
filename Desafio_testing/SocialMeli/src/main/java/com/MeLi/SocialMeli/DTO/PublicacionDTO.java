package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Producto;
import com.MeLi.SocialMeli.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO{

    @NotNull(message = "user_id no puede estar vacío.")
    @Min(value = 1, message = "El user_id debe ser mayor a 0")
    private Integer user_id;

    @NotNull(message = "id_post no puede estar vacío")
    @Min(value = 1, message = "El id_post debe ser mayor a 0")
    private Integer id_post;

    @NotNull(message = "date no puede estar vacío.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;


    @Valid
    private ProductoDTO detail;

    @NotNull(message = "Category no puede estar vacío")
    @Positive
    private Integer category;

    @NotNull(message = "price no puede estar vacío")
    @Min(0)
    @Max(10000000)
    private Integer price;
}
