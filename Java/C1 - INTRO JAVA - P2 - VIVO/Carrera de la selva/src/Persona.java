public class Persona {
    int dni;
    String nombre;
    String apellido;
    int edad;
    long celular;
    long numero_de_emergencia;
    String grupo_sanguineo;

    public Persona(int dni, String nombre, String apellido, int edad, long celular, long numero_de_emergencia, String grupo_sanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numero_de_emergencia = numero_de_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getNumero_de_emergencia() {
        return numero_de_emergencia;
    }

    public void setNumero_de_emergencia(long numero_de_emergencia) {
        this.numero_de_emergencia = numero_de_emergencia;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    @Override
    public String toString() {
        return "Nombre: "+ this.nombre +" - Apellido: "+ this.apellido +" - DNI: "+ this.dni +" - Edad: "+ this.edad
                +" - Celular: "+ this.celular +" - Numero de emergencia: "+ this.numero_de_emergencia
                +" - Grupo sanguineo: "+ this.grupo_sanguineo;
    }
}