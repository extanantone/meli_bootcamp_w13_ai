package com.example.c2_dto_resp_ent_p2_vivo.dto;

import com.example.c2_dto_resp_ent_p2_vivo.model.Deporte;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SportPersonDTO
{
    String nombre;
    String apellido;
    List<Deporte> nombreDeportes;
}
