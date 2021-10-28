import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        List<Producto> productoList = new ArrayList<Producto>();

        Perecedero huevos = new Perecedero("Huevos", 10000, 2);
        NoPerecedero escoba = new NoPerecedero("Escoba", 7000, "Limpieza");
        Perecedero leche = new Perecedero("Leche", 13000, 15);
        NoPerecedero jabon = new NoPerecedero("Jabon", 3000, "Cuidado personal");
        Perecedero harina = new Perecedero("Harina", 5000, 1);

        productoList.add(huevos);
        productoList.add(escoba);
        productoList.add(leche);
        productoList.add(jabon);
        productoList.add(harina);

        for( Producto prod : productoList){
            System.out.println("El precio de 5 productos para " +
                    prod.getNombre() +
                    " es de " +
                    prod.calcular(5));
        }
    }
}
