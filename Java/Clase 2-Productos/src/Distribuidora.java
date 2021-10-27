import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) throws Exception{
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecederos("Carne", 500, 1));
        productos.add(new Perecederos("Pollo", 760, 3));
        productos.add(new Perecederos("Pescado", 800, 2));
        productos.add(new Perecederos("Cerdo", 455, 3));
        productos.add(new Perecederos("Caballo", 352, 4));

        productos.add(new NoPerecederos("Arroz", 200, "almacen"));
        productos.add(new NoPerecederos("Polenta", 110, "almacen"));
        productos.add(new NoPerecederos("Soja", 330, "almacen"));
        productos.add(new NoPerecederos("Leche", 180, "almacen"));
        productos.add(new NoPerecederos("Harina", 230, "almacen"));

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
