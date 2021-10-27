package ejericiciopractico.e1;

public class PersonalMantenimiento extends Persona implements FuncionariosUniversidad{

    public PersonalMantenimiento(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        super(dni, edad, nombre, apellido, idUniversidad);
    }

    @Override
    public void obtenerEquipos() {
        System.out.println("puede solicitar acceso a equipo de mantenimiento de las instlaaciones de la universidad");
    }

    @Override
    public int definirAccesos() {
        return 1;
    }

    @Override
    public void realizarFuncionPrinicipal() {
        System.out.println("realizar Mantenimiento");
    }

    @Override
    protected void protocoloIngreso() {
        System.out.println("cualquier peurta cualquier hora");
    }
}
