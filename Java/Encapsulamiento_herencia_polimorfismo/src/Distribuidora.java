import java.util.ArrayList;

public class Distribuidora {

    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public Distribuidora(ArrayList<Producto> productos) {
        this.productos.addAll(productos);
    }

    public void vender(){
        double total = 0;
        for(Producto p: this.productos){
            total = total + p.calcular(5);
        }
        System.out.println(total);
    }
}
