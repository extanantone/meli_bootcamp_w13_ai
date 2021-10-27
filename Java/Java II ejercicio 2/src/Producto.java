
import java.util.List;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public static Producto findProduct(List<Producto> productos, String prodFind){
        for(Producto prod: productos) {
            if(prod.getNombre() == prodFind){
                return prod;
            }
        };
        /// iria un scanner para crear nuevo producto
        Producto newProd = new Producto(prodFind,1500);
        return newProd;
    };

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcular(int cantProductos){
        return cantProductos*this.precio;
    }



    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
