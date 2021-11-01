package bootcamp.models;

import bootcamp.main.CRUD;
import bootcamp.main.GestorFactura;
import bootcamp.main.GestorProducto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Factura {

    private static int incremental = 0;
    private int codFactura;
    private Cliente cliente;
    private HashMap<Integer,Integer> productos;
    private double costoTotal;

    public Factura( Cliente cliente, HashMap<Integer, Integer> productos) {
        int incremento = incremental++;
        this.codFactura = incremento;
        this.cliente = cliente;
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public HashMap<Integer, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Integer, Integer> productos) {
        this.productos = productos;
    }

    public void recorrerItemsEnFactura(){

        for (Map.Entry<Integer,Integer> codProd: productos.entrySet()) {
            Producto p = GestorProducto.obtenerDetalleProducto(codProd.getKey());
            p.toString();
        }

    }

    public double calcularTotalFactura(){

        double montoTotal = 0;

        for (Map.Entry<Integer,Integer> codProd: productos.entrySet()) {
            Producto p = GestorProducto.obtenerDetalleProducto(codProd.getKey());
            montoTotal += p.getCostoUnitario() * codProd.getValue();
        }

        return montoTotal;
    }


}
