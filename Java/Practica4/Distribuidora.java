import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Perecedero("A",1,1));
        listaProductos.add(new Perecedero("B",2,2));
        listaProductos.add(new Perecedero("C",3,3));
        listaProductos.add(new Perecedero("D",4,1));
        listaProductos.add(new Perecedero("E",5,2));
        listaProductos.add(new NoPerecedero("F",5,"enlatado"));
        listaProductos.add(new NoPerecedero("G",4,"plastico"));
        listaProductos.add(new NoPerecedero("H",3,"congelado"));
        listaProductos.add(new NoPerecedero("I",2,"enlatado"));
        listaProductos.add(new NoPerecedero("J",1,"congelado"));

        for(int i = 0; i < listaProductos.size(); i++){
            System.out.println(listaProductos.get(i).toString());
            System.out.println(listaProductos.get(i).calcular(5));
        }
    }
}
