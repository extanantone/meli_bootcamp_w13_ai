import productos.Producto;

import java.util.ArrayList;

public class Localizador {

    private static int idIncremental = 0;
    private int idLocalizador;
    private Cliente cliente;
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private double total;

    public Localizador(Cliente cliente) {
        idIncremental++;
        this.idLocalizador = idIncremental;
        this.cliente = cliente;
    }

    public static int getIdIncremental() {
        return idIncremental;
    }

    public static void setIdIncremental(int idIncremental) {
        Localizador.idIncremental = idIncremental;
    }

    public int getIdLocalizador() {
        return idLocalizador;
    }

    public void setIdLocalizador(int idLocalizador) {
        this.idLocalizador = idLocalizador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "idLocalizador=" + idLocalizador +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}
