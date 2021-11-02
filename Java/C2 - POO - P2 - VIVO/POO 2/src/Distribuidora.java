import java.util.*;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new NoPerecedero(
                "fideos",
                100,
                "No perecedero"
        ));

        productos.add(new Perecedero(
                "tomates",
                100,
                3
        ));

        double totalCompra = 0;
        for(Producto item :productos) {
            System.out.println(item + " total: "+ item.calcular(5));
        }
    }
}
