package C3.noche;

public class Tutor extends Estudiante{

    public Tutor(String nombre, String dni, String codigoEstudiante) {
        super(nombre, dni, codigoEstudiante);
    }

    @Override
    public void funcionEstudiante() {
        System.out.println("Elegidos para enseñar algo en particular");
    }

    @Override
    public String saludar() {
        return super.saludar() + " .Enseño algo particular";
    }
}
