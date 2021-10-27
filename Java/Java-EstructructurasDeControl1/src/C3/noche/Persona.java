package C3.noche;

public abstract class Persona {
    private String nombre;
    private String dni;
    private int telefono;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        this.dni = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public abstract String saludar();
}
