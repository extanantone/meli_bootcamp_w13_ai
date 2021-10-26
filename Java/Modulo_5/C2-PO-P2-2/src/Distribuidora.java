import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(new Perecedero("fruta", 25, 1));
        productos.add(new Perecedero("pescado", 50, 2));
        productos.add(new Perecedero("carne", 100, 3));
        productos.add(new Perecedero("leche", 150, 4));
        productos.add(new Perecedero("jamon", 200, 6));

        productos.add(new NoPerecedero("detergente", 80));
        productos.add(new NoPerecedero("jabon", 60));
        productos.add(new NoPerecedero("computador", 1000));
        productos.add(new NoPerecedero("silla", 300));
        productos.add(new NoPerecedero("bicicleta", 800));

        double precioTotal = 0;

        for (Producto producto:
             productos) {

            precioTotal += producto.calcular(1);
        }

        System.out.println("El precio total de los productos es de: " + precioTotal);
    }
}
