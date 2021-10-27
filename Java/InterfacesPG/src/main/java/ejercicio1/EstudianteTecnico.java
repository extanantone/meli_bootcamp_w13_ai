package ejercicio1;

public class EstudianteTecnico extends Estudiante implements Supports{


    public EstudianteTecnico(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void darSoporte() {
        System.out.println("Esta brindando soporte el Estudiante Técnico " + getNombre() + getApellido());
    }
}
