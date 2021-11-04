package com.MeliBoot.food.services.ServicesImplements;

import com.MeliBoot.food.models.Plato;
import com.MeliBoot.food.services.PlatoService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements PlatoService {

    List<Plato> platosAGuardar = new ArrayList<>();

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
    }

}
