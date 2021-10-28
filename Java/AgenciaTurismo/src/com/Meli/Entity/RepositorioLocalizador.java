package com.Meli.Entity;

import java.util.List;
import java.util.stream.Stream;

public class RepositorioLocalizador extends Repositorio{

    @Override
    public void add(Object elemento) {
        Localizador localizador = (Localizador) elemento;

        Stream stClientes = this.elementos.stream().filter(x->((Localizador)x).getCliente().equals(localizador.getCliente()));
        Long cant = stClientes.count();
        if(cant >=2){
            localizador.getCliente().setDescuento(0.05f);
        }

        this.elementos.add(localizador);
    }
}
