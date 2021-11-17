package com.SocialMeli.Sprint1SocialMeli.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {

    private int user_id,id_post,category;
    private double price;
    private String date;
    private ProductoDTO detail;

}
