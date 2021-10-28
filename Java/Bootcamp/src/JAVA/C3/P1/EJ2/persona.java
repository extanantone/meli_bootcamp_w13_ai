package JAVA.C3.P1.EJ2;

import java.util.List;

//lo tuve que poner en minúscula por un problema con intelijj
public class persona {
    private String Nombre;
    private String apellido;
    private int DNI;
    private List<String> habilidades;

    public persona(String nombre, String apellido, int DNI, List<String> habilidades) {
        Nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.habilidades = habilidades;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
}
