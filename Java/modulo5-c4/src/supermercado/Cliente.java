package supermercado;

public class Cliente {
    String nombre;
    String apellido;
    String dni;

    public Cliente(String inNombre, String inApellido, String inDni) {
        this.nombre = inNombre;
        this.apellido = inApellido;
        this.dni = inDni;
    }

    public String getDni() {
        return this.dni;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s - Apellido: %s - DNI: %s",
                this.nombre, this.apellido, this.dni);
    }
}
