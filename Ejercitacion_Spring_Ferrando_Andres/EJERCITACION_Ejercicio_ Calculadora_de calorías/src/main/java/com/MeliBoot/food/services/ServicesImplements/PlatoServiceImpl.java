package com.MeliBoot.food.services.ServicesImplements;

import com.MeliBoot.food.models.Ingrediente;
import com.MeliBoot.food.models.Plato;
import com.MeliBoot.food.repository.IngredienteRepository;
import com.MeliBoot.food.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    IngredienteRepository ingredienteRepository;

/*    List<Plato> platosAGuardar = new ArrayList<>();

    public void inicializarPlatos(){
        Plato p = new Plato("Salmon con Brócoli");
        platosAGuardar.add(p);
        p = new Plato("Ternera con Papas Cocidas y Pimiento");
        platosAGuardar.add(p);
        p = new Plato("Pollo con Tomate y Rúcula");
        platosAGuardar.add(p);
        p = new Plato("Flan de Vainilla");
        platosAGuardar.add(p);
        p = new Plato("Mousse de Chocolate Con Leche");
        platosAGuardar.add(p);
        p = new Plato("Copos de maíz con Leche de almendras");
        platosAGuardar.add(p);
    }

    @Override
    public List<Plato> getPlatos(String plato) {
        inicializarPlatos();
        return platosAGuardar.stream().filter(x -> x.getNombreDelPlato() == plato).collect(Collectors.toList());
    }*/

    @Override
    public int calculo(Plato plato) {
        List<Ingrediente> ingredientes = ingredienteRepository.getIngredientesBD();
        List<Ingrediente> ingredientesPlato = plato.getIngredientes();

        int calorias = 0;

        for (int i = 0; i < ingredientesPlato.size(); i++) {
            for (int j = 0; j < ingredientes.size(); j++) {

                if (ingredientes.get(j).getNombre().equals(ingredientesPlato.get(i).getNombre())) {
                    calorias += (ingredientes.get(j).getCalorias() * ingredientesPlato.get(i).getPeso()) / 100;
                }
            }
        }
        return calorias;
    }
}
