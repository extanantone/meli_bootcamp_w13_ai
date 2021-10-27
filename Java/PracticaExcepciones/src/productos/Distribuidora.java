package productos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("prod1", 10.0, 1));
        productos.add(new NoPerecedero("prod2", 20.0, "vehiculo"));
        productos.add(new Perecedero("prod3", 30.0, 4));
        productos.add(new Perecedero("prod4", 60.0, 3));
    }
}
