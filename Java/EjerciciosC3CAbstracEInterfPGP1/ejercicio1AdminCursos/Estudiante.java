package ejercicio1AdminCursos;

public class Estudiante extends Persona{

    private String codigo;

    private String programa;

    private String fechaIngreso;

    private int semestreActual;

    public Estudiante(String identificacion, String nombre, String codigo, String programa, String fechaIngreso, int semestreActual) {
        super(identificacion, nombre);
        this.codigo = codigo;
        this.programa = programa;
        this.fechaIngreso = fechaIngreso;
        this.semestreActual = semestreActual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }

    @Override
    public String toString() {
        return super.toString() + ", codigo : " + this.codigo +
                ", programa : " + this.programa;
    }
}
