package Supermercado;

import java.util.ArrayList;
import java.util.HashMap;


public class Factura implements CRUD<Item, Integer> {
    private Cliente cliente;
    private HashMap<Integer, Item> listaItems = new HashMap();
    private int precioTotal = 0;

    public Factura(Cliente cliente, HashMap<Integer, Cliente> list) {
        this.cliente = cliente;
        if (list.containsKey(cliente.getDni())) {
            list.put(cliente.getDni(), cliente);
        }
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", precioTotal=" + precioTotal +
                '}';
    }

    @Override
    public void alta(Item data) {
        listaItems.put(data.getCodigo(), data);
        precioTotal += data.getCantidad() * data.getCosto();
    }

    @Override
    public Item consulta(Integer info) {
        return listaItems.get(info);
    }

    @Override
    public void modificacion(Item data) {
        Item remove = listaItems.get(data.getCodigo());
        if (remove != null) {
            precioTotal -= remove.getCantidad() * remove.getCosto();
            listaItems.put(data.getCodigo(), data);
            precioTotal += data.getCantidad() * data.getCosto();
        }
    }

    @Override
    public Item baja(Integer info) {
        Item data = listaItems.remove(info);
        ;
        precioTotal -= data.getCantidad() * data.getCosto();
        return data;
    }
}
