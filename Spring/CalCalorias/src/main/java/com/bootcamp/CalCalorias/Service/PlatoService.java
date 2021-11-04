package com.bootcamp.CalCalorias.Service;

import com.bootcamp.CalCalorias.Exceptions.NotFoundException;
import com.bootcamp.CalCalorias.Exceptions.NullException;
import com.bootcamp.CalCalorias.Model.Ingredientes;
import com.bootcamp.CalCalorias.Model.Plato;
import com.bootcamp.CalCalorias.Model.InfoPlato;
import com.bootcamp.CalCalorias.Repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService implements IPlatoService{

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public InfoPlato calculo(Plato plato) {
        int tot=0;
        int maxCal=0;
        InfoPlato calorias = new InfoPlato(plato);
        for (Ingredientes i:calorias.getIngredientes()) {
            calculoCalorias(i);
            tot += i.getCalorias();
            if(i.getCalorias() > maxCal){
                calorias.setMayorCaloria(i);
                maxCal = i.getCalorias();
            }
        }
        calorias.setTotalCalorias(tot);
        return calorias;
    }


    private void calculoCalorias(Ingredientes ingredient) {
        ingredient.setCalorias(0);
        Ingredientes ingrRepo = ingredienteRepository.getNombreIngrediente(ingredient.getNombre());
        if (ingrRepo != null){
            ingredient.setCalorias((int) (ingredient.getPeso() * ingrRepo.getCalorias() / 100.f));
        }else{
            throw new NullException("Ingredientes no puede ser nulo! "+ingrRepo);
        }

    }
}
