package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListadoPublicacionesDTO {
    private int user_id;
    private List<Publicacion> posts;

}
