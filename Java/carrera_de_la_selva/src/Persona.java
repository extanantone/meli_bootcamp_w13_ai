public class Persona {

    int dni;
    String nombre;
    String apellido;
    short edad;
    public Persona(int dni, String nombre, String apellido, short edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public short getEdad(){
        return edad;
    }
}