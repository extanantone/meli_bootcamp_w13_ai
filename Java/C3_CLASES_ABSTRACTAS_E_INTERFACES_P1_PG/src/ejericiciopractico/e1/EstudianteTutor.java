package ejericiciopractico.e1;

public class EstudianteTutor extends Estudiantes implements FuncionariosUniversidad{

    public EstudianteTutor(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        super(dni, edad, nombre, apellido, idUniversidad);
    }

    @Override
    public void obtenerEquipos() {
        System.out.println("Los tutores pueden obtener proyectores y aulas");
    }

    @Override
    public int definirAccesos() {
        return 3;
    }

    @Override
    public void realizarFuncionPrinicipal() {
        System.out.println("dar clase de manera amena");
    }

}
