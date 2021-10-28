package com.company;

import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> items;
    Double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = items.stream().mapToDouble(a -> a.getCantComprada() * a.getCostoUnitario()).sum();
    }
}
