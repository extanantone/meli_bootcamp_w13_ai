package Excepciones;
import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        {
            ArrayList<Producto> productos = new ArrayList<Producto>();

            Producto producto1 = new Perecedero("Pollo", 33, 1);
            Producto producto2 = new Perecedero("Pescado", 28, 1);
            Producto producto3 = new Perecedero("Cerdo", 40, 2);
            Producto producto4 = new Perecedero("Frutas", 11, 1);
            Producto producto5 = new Perecedero("Verduras", 12, 2);

            Producto producto6 = new NoPerecedero("Arroz", 10, "almacen");
            Producto producto7 = new NoPerecedero("Azucar", 30, "almacen");
            Producto producto8 = new NoPerecedero("Yerba", 20, "almacen");
            Producto producto9 = new NoPerecedero("Leche", 15, "almacen");
            Producto producto10 = new NoPerecedero("Harina", 20, "almacen");


            productos.add(producto1);
            productos.add(producto2);
            productos.add(producto3);
            productos.add(producto4);
            productos.add(producto5);

            productos.add(producto6);
            productos.add(producto7);
            productos.add(producto8);
            productos.add(producto9);
            productos.add(producto10);

            int cantidadVendidos = 10;
            double precioAcumulado = 0.0;
            for(Producto elementos:productos)
            {
                System.out.println(elementos.getNombre() +" $" + elementos.calcular(cantidadVendidos));
                precioAcumulado = precioAcumulado+elementos.calcular(cantidadVendidos);
            }
            System.out.println("El total de todo lo vendido es: $" + precioAcumulado);

        }
    }
}