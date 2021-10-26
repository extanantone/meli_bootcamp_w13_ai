import java.util.ArrayList;
import java.util.Random;

public class Distribuidora {

    public static void main(String[] args){
        ArrayList<Producto> arrProductos= new ArrayList<>();
        String[] nombresPerecederos= {"Leche", "Azucar", "Atun", "Carne", "Sardinas"};
        String[] nombresNoPerecederos= {"Agua", "Huevos", "Manzanas", "Frijoles", "Jabon"};

        for(int i=1; i<=nombresPerecederos.length; i++){
            arrProductos.add(new Perecedero(nombresPerecederos[i-1], new Random().nextInt(10000), i));
            arrProductos.add(new NoPerecedero(nombresNoPerecederos[i-1], new Random().nextInt(10000), "De primera necesidad"));
        }

        for (Producto p: arrProductos){
            System.out.println(p.toString() + ". Cantidad de productos: 5");
            System.out.println("Valor final: " + p.calcular(5));
            System.out.println("******");
        }
    }
}
