package bootcamp.models;

import bootcamp.main.GestorProducto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Factura {

    private int codFactura;
    private Cliente cliente;
    private HashMap<Integer,Integer> productos;
    private double costoTotal;

    public Factura(Cliente cliente, HashMap<Integer,Integer> productos, double costoTotal) {
        this.cliente = cliente;
        this.productos = productos;
        this.costoTotal = costoTotal;
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
            Optional<Producto> p = GestorProducto.obtenerDetalleProducto(codProd.getKey());
            p.toString();
        }

    }


}
