package Java_IV;

public class Cliente {
    private String dni;
    private String nombre;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "dni='" + dni + '\'' + "\n" +
                "nombre='" + nombre + '\''
                ;
    }
}
