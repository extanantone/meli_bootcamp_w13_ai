package Ejercicio2CarreraSelva;

public class Participante {

    private int dni;

    private String nombre;

    private String apellido;

    private int edad;

    private int celular;

    private int numEmergencia;

    private String grupoSanguineo;

    private Categorias categoria;

    private int costoInscripcion;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int numEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria=null;
        this.costoInscripcion = -1;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public int getCostoInscripcion() {
        return costoInscripcion;
    }

    public void setCostoInscripcion(int costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(int numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Participante{");
        sb.append("dni=").append(dni);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", celular=").append(celular);
        sb.append(", numEmergencia=").append(numEmergencia);
        sb.append(", grupoSanguineo='").append(grupoSanguineo).append('\'');
        sb.append(", categoria=").append(categoria);
        sb.append(", costoInscripcion=").append(costoInscripcion);
        sb.append('}');
        return sb.toString();
    }
}
