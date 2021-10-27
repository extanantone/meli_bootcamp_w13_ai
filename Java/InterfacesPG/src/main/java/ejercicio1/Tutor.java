package ejercicio1;

public class Tutor extends Estudiante implements Teaches{

    public Tutor(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void ensenar() {
        System.out.println("Esta enseñando el tutor " + getNombre() + getApellido());
    }
}
