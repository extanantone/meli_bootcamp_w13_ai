package ejericiciopractico.p2;

public class Participante {

    private long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private long celular;
    private long numeroEmerg;
    private String grupoSanguineo;
    private double valorInscripcion;


    private long consecutivoUnico;

    public Participante(long dni, String nombre, String apellido, int edad, long celular, long numeroEmerg, String grupoSanguineo, double valorInscripcion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmerg = numeroEmerg;
        this.grupoSanguineo = grupoSanguineo;
        this.valorInscripcion = valorInscripcion;
    }

    public long getConsecutivoUnico() {
        return consecutivoUnico;
    }

    public void setConsecutivoUnico(long consecutivoUnico) {
        this.consecutivoUnico = consecutivoUnico;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
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

    public long getNumeroEmerg() {
        return numeroEmerg;
    }

    public void setNumeroEmerg(long numeroEmerg) {
        this.numeroEmerg = numeroEmerg;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public double getValorInscripcion() {
        return valorInscripcion;
    }

    public void setValorInscripcion(double valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }
}