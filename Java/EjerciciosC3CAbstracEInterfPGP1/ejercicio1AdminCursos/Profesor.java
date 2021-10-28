package ejercicio1AdminCursos;

public class Profesor extends Persona{

    private String facultad;

    private String codigoDocente;

    public Profesor(String identificacion, String nombre, String facultad, String codigoDocente) {
        super(identificacion, nombre);
        this.facultad = facultad;
        this.codigoDocente = codigoDocente;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    @Override
    public String toString() {
        return super.toString() + ", codigo docente : " + this.codigoDocente +
                ", programa : " + this.facultad;
    }
}
