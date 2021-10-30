package Pack;

public class Cliente {

    private String nombre,apellido;
    private int dni;
    private int nroCLiente;

    public Cliente(String nombre, String apellido, int dni, int nroCLiente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nroCLiente = nroCLiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNroCLiente() {
        return nroCLiente;
    }

    public void setNroCLiente(int nroCLiente) {
        this.nroCLiente = nroCLiente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", nroCLiente=" + nroCLiente +
                '}';
    }
}
