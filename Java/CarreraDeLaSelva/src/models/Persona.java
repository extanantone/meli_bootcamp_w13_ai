package models;

public class Persona {

    int dni, telefono, telEmergencia,edad;
    String nombre,apellido, grupoSanguineo;

    public Persona(int dni, int telefono, int telEmergencia, int edad, String nombre, String apellido, String grupoSanguineo) {
        this.dni = dni;
        this.telefono = telefono;
        this.telEmergencia = telEmergencia;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelEmergencia() {
        return telEmergencia;
    }

    public void setTelEmergencia(int telEmergencia) {
        this.telEmergencia = telEmergencia;
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

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
