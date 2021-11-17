package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Producto;
import com.MeLi.SocialMeli.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO{
    private int user_id;
    private int id_post;
    private String date;
    private ProductoDTO detail;
    private int category;
    private int price;
}
