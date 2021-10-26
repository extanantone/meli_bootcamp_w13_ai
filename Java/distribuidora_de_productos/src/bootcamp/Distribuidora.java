package bootcamp;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) throws Exception {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Carne", 500, 1));
        productos.add(new Perecedero("Pollo", 760, 3));
        productos.add(new Perecedero("Pescado", 800, 2));
        productos.add(new Perecedero("Cerdo", 455, 3));
        productos.add(new Perecedero("Caballo", 352, 4));

        productos.add(new NoPerecedero("Arroz", 200, "almacen"));
        productos.add(new NoPerecedero("Polenta", 110, "almacen"));
        productos.add(new NoPerecedero("Soja", 330, "almacen"));
        productos.add(new NoPerecedero("Leche", 180, "almacen"));
        productos.add(new NoPerecedero("Harina", 230, "almacen"));

        if(productos.size() != 10){
            throw new Exception("La cantidad de productos debe ser de 10!");
        }

        double costoAcumulado = 0;
        int i = 1;

        for (Producto prod: productos) {
            costoAcumulado += prod.calcular(i);

            i++;
        }

        System.out.println("El costo total es: " + costoAcumulado);

    }
}
