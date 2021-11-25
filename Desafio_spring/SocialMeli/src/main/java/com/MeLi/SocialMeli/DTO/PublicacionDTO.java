package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Producto;
import com.MeLi.SocialMeli.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO{
    private int user_id;
    private int id_post;

    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductoDTO detail;
    private int category;
    private int price;
}
