package com.bootcamp.calorias.dto;

import java.util.List;

public class DTOPlato {
    private String name;
    private List<DTOIngrediente> ingredientes;

    public DTOPlato(String name, List<DTOIngrediente> ingredientes) {
        this.name = name;
        this.ingredientes = ingredientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DTOIngrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<DTOIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
