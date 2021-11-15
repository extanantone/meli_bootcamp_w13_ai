package com.company.recipes.service.impl;

import com.company.recipes.dto.IngredienteDTO;
import com.company.recipes.dto.PlatoDTO;
import com.company.recipes.model.Ingrediente;
import com.company.recipes.model.Plato;
import com.company.recipes.repository.IngredienteRepository;
import com.company.recipes.service.PlatoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    IngredienteRepository repository;

    @Override
    public Integer getCalorias(PlatoDTO plato) {
        Integer calorias = 0;
        for ( IngredienteDTO ingrediente: plato.getIngredientes()) {
            Ingrediente ingr = this.repository.getIngredienteByName(ingrediente.getNombre());
            if(ingr != null) {
                calorias += ingr.getCalories() * ingrediente.getCalorias();
            }
        }
        return calorias;
    }
}
