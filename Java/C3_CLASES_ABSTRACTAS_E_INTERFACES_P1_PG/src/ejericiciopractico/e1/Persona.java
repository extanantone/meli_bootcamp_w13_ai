package ejericiciopractico.e1;

public abstract class Persona {

    String dni;
    int edad;
    String nombre;
    String apellido;
    String idUniversidad;

    public Persona(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUniversidad = idUniversidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(String idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    protected abstract void protocoloIngreso();

}
