public class Profesor extends Persona implements Enseñar{
    private String materia;

    @Override
    public void enseñar() {
        System.out.println("Profesor enseñando");
    }
}
