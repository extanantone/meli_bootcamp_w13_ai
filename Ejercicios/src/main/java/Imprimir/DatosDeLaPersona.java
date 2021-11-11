package Imprimir;

public class DatosDeLaPersona {
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

    public DatosDeLaPersona(int documento, String nombre, String apellido, String trabajo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
    }

    @Override
    public String toString() {
        return "datos de la persona {" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", trabajo='" + trabajo + '\'' +
                '}';
    }
}
