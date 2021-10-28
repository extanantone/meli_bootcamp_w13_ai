package Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> listaItems;
    private int precioTotal;

    public Factura(Cliente cliente, List<Cliente> list, ArrayList<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.precioTotal = listaItems.stream()
                .reduce(0,(acc,cv)->(acc += cv.getCosto() * cv.getCantidad()), Integer::sum);
        boolean exist = list.stream()
                .reduce(false, (acc,cv) -> (cv.getDni() == cliente.getDni()) || acc, Boolean::logicalOr );
        if(!exist){list.add(cliente);}
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
