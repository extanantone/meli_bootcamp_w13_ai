package Imprimir;

public class Datos {
    int documento;
    String nombre;
    String apellido;
    String trabajo;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Datos(int documento, String nombre, String apellido, String trabajo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
    }

    @Override
    public String toString() {
        return "datos {" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", trabajo='" + trabajo + '\'' +
                '}';
    }
}
