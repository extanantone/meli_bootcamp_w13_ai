package C3.noche;

public abstract class Estudiante extends Persona{

    private String codigoEstudiante;

    public Estudiante(String nombre, String dni, String codigoEstudiante) {
        super(nombre, dni);
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public abstract void funcionEstudiante();

    @Override
    public String saludar() {
        return "Hola mi nombre es "+getNombre()+" y soy estudiante";
    }
}
