package Productos;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String inNombre, double inPrecio, String inTipo) {
        super(inNombre, inPrecio);
        this.tipo = inTipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String inTipo) {
        this.tipo = inTipo;
    }

    @Override
    public String toString() {
        return String.format("+ Nombre: %s\n+ Precio: %f\n+ Tipo: %s",
                this.nombre, this.precio,this.tipo);
    }
}
