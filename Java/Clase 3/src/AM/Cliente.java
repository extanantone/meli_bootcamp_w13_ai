package AM;

public abstract class Cliente {
    private String nombre;
    private String apellido;
    private int nroDeCliente;

    public Cliente(String nombre, String apellido, int nroDeCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDeCliente = nroDeCliente;
    }
}