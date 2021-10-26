package JAVA.C1.P2.EJ2;

//tuve que crear la clase en minúscula porque intelijj me tiraba error con "Persona".
public class persona {
    int dni;
    String nombre;
    String apellido;
    int edad;
    long celular;
    long numeroEmergencia;
    String grupoSanguineo;
    int numeroParticipante;

    public persona(int dni, String nombre, String apellido, int edad, long celular, long numeroEmergencia, String grupoSanguine, int numeroParticipante) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.numeroParticipante = numeroParticipante;
    }

    public persona() {

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

    public long getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(long numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

}
