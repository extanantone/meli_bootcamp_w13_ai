package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private List<Factura> facturas;
    private String dni;
    private String nombre;

    public Cliente(String nombre,String dni){
        this.facturas = new ArrayList<>();
        this.nombre = nombre;
        this.dni = dni;
    }

    public void addFactura(Factura factura){
        facturas.add(factura);
    }

    public void addItemFactura(int idFactura,Item item){
        Factura factura = getFactura(idFactura);
        if(factura!=null){
            factura.addItem(item);
        }
    }

    private Factura getFactura(int idFactura){
        return facturas.stream().filter(it->it.getId()==idFactura).
                findFirst().orElse(null);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    
}
