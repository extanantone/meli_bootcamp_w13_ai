package com.Spring.C3P2.CalculadoraCalorias.Service;

import com.Spring.C3P2.CalculadoraCalorias.DTO.IngredienteDTO;
import com.Spring.C3P2.CalculadoraCalorias.DTO.PlatoDTO;
import com.Spring.C3P2.CalculadoraCalorias.Model.Ingrediente;
import com.Spring.C3P2.CalculadoraCalorias.Repository.IIngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService implements IPlatoService{

    IIngredienteRepository ingredienteRepo;

    public PlatoService(IIngredienteRepository ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }

    @Override
    public int obtenerCalorias(PlatoDTO plato) {
        List<IngredienteDTO> ingredientesPlato = plato.getIngredients();
        int totalCalorias = 0;

        for (IngredienteDTO ingDTO : ingredientesPlato) {
            Ingrediente ingModel = ingredienteRepo.ObtenerIngrediente(ingDTO.getName());

            if (ingModel != null)
                totalCalorias += (ingDTO.getWeight() * ingModel.getCalories()) / 100;

        }

        return totalCalorias;
    }
}
