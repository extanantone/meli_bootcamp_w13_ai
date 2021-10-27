public class Tutor extends Estudiante {

    private String Materia;

    public Tutor(String nombre, String apellido, String legajo, String materia) {
        super(nombre, apellido, legajo);
        Materia = materia;
    }

    @Override
    public String hace(){
        return "Estudia y Da clase de " + Materia;
    }
}
