package com.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    @NotNull(message = "el id de usuario no puede ser vacio")
    @Positive(message = "no se permite numeros negativos")
    private Integer userId;

    @NotNull
    @Positive(message = "No se permite numeros negativos")
    private Integer idPost;


    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty(message = "La fecha no puede estar vacia")
    private String date;


    @Valid
    @NotNull(message = "El detalle no puede ser nulo")
    private DetailDto detail;

    @NotNull(message = "La categoria no puede estar vacia")
    private Integer category;

    @NotNull(message = "El precio no puede estar vacio")
    private Double price;
}
