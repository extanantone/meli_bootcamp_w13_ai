package com.example.bootcamp.comida.mapper;

import com.example.bootcamp.comida.dto.PlatoDTO;
import com.example.bootcamp.comida.model.Plato;
import org.springframework.stereotype.Component;

@Component
public class PlatoMapper {

    public static Plato PlatoDTOToPlato(PlatoDTO platoDTO){

        Plato plato = new Plato();
        plato.setName(platoDTO.getName());
        plato.setListaIngredientes(platoDTO.getIngrendients());
        return plato;
    }

    public static PlatoDTO PlatoToPlatoDTO(Plato plato){

        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setName(plato.getName());
        platoDTO.setIngrendients(plato.getListaIngredientes());
        return platoDTO;
    }

}
