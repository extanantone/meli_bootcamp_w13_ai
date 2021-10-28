package com.app;

import com.app.crud.CrudRepository;
import com.app.crud.impl.ClienteRepository;
import com.app.model.Cliente;
import com.app.model.Factura;
import com.app.model.Item;

public class App{
    public static void main(String[] args) {
        CrudRepository<Cliente,String> repo = new ClienteRepository();
        Cliente cliente = new Cliente("Juan","1000");
        Factura factura = new Factura();
        cliente.addFactura(factura);
        repo.add(cliente);
        factura.addItem(new Item("Pasta", 12, 1000));
        factura.addItem(new Item("Tomate", 3, 200));
        System.out.println(factura.getTotalPrice());
    }
}