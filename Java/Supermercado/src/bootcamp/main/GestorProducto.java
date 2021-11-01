package bootcamp.main;

import bootcamp.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class GestorProducto {

    public static List<Producto> productosEnStock;


    public static void inicializarProductos(){

        productosEnStock = new ArrayList<Producto>();
        Producto serenitoVainilla = new Producto(1,"Serenito Vainilla",20.5);
        Producto serenitoDulceLeche = new Producto(2,"Serenito DdL",22.5);
    }

    public static void agregarProducto(Producto p){
        productosEnStock.add(p);
    }

    public static void eliminarProductoDeStock (Integer codigo){

        List<Producto> productosAEliminar = new ArrayList<Producto>();
        productosAEliminar = (List<Producto>) productosEnStock.stream().filter(x -> x.getCodigo() == codigo);
        productosEnStock.removeAll(productosAEliminar);

    }

    public static Producto obtenerDetalleProducto(Integer codigoProducto){

        return productosEnStock.stream().filter(x -> x.getCodigo() == codigoProducto).findFirst().orElse(null);

    }

    public static void mostrarTodosLosProductos(){

        productosEnStock.stream().forEach(System.out::println);

    }



}
