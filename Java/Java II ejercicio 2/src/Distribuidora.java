import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {



    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();


        productos.add(new NoPerecedero("camisas",1000,"textil"));
        productos.add(new NoPerecedero("tela",1000,"textil"));
        productos.add(new Producto("bici",1000));
        productos.add(new Producto("tele",1000));
        productos.add(new Perecedero("carro",1000,3));
        productos.add(new Perecedero("closet",1000,3));

        int validate = 0;



        double total = 0;

        while (validate < 5) {
            Scanner prodSearch = new Scanner(System.in);

            System.out.println("Ingrese el nombre del producto");
            String prod = prodSearch.nextLine();

            Producto prodSelect = Producto.findProduct(productos,prod);

            System.out.println("Ingrese la cantidad");
            int cantidad = prodSearch.nextInt();

            total = total + prodSelect.calcular(cantidad);

            validate++;

        }

        System.out.println("el total de la compra fue:" + total);






    }
}
