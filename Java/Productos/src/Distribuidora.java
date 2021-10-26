import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<Producto>();

        Producto producto1 = new Perecedero("Pan",10,1);
        Producto producto2 = new Perecedero("Queso",20,2 );
        Producto producto3 = new Perecedero("Jamon",30,3 );
        Producto producto4 = new Perecedero("Tomate",40,1  );
        Producto producto5 = new Perecedero("Hamburguesa",50,2  );

        Producto producto6 = new NoPerecedero("Leche",10,"Frio" );
        Producto producto7 = new NoPerecedero("fideos",20,"Seco"  );
        Producto producto8 = new NoPerecedero("Dulce de leche",20, "Sin TACC" );
        Producto producto9 = new NoPerecedero("Galleta de arroz",50,"Sin gluten"  );
        Producto producto10 = new NoPerecedero("Jamon Crudo",60,"Fiambre"  );

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

        for (Producto p : productos) {
            System.out.println(p.calcular(10));
        }
    }
}
