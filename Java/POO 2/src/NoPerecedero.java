public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero() {

    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Precio: "+ this.precio +" Tipo: "+this.tipo;
    }
}
