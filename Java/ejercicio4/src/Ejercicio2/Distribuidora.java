package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {

    private static List<Producto> productos = new ArrayList<>(
            Arrays.asList(
                    new Perecedero("Leche", 67.8, 3),
                    new NoPerecedero("Arroz", 31.5, "Cereal"),
                    new Perecedero("Manteca", 120, 1),
                    new NoPerecedero("Fideos", 27, "Pastas"),
                    new Perecedero("Queso Untable", 115, 2)
            )
    );

    static double calcularPrecio(List<Producto> productos) {
        return productos.stream()
                .map(producto -> producto.calcular(5))
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.printf("La venta da un total de %.2f", calcularPrecio(productos));
    }
}
