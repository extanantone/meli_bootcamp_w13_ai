public class Participante {

    private int dni;
    private String nombre;
    private String apellido;
    private int nroEmergencia;
    private String grupoSanguineo;
    private int celular;
    private int edad;
    private int tipoDeCarrera;
    private double montoInscripcion;

    public Participante(int dni, String nombre, String apellido, int nroEmergencia, String grupoSanguineo, int celular, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.celular = celular;
        this.edad = edad;
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

    public int getNroEmergencia() {
        return nroEmergencia;
    }

    public void setNroEmergencia(int nroEmergencia) {
        this.nroEmergencia = nroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTipoDeCarrera() {
        return tipoDeCarrera;
    }

    public void setTipoDeCarrera(int tipoDeCarrera) {
        this.tipoDeCarrera = tipoDeCarrera;
    }

    public double getMontoInscripcion() {
        return montoInscripcion;
    }

    public void setMontoInscripcion(double montoInscripcion) {
        this.montoInscripcion = montoInscripcion;
    }
}
