package ejericiciopractico.e1;

public class Docente extends Persona implements FuncionariosUniversidad{

    public Docente(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        super(dni, edad, nombre, apellido, idUniversidad);
    }

    @Override
    public void obtenerEquipos() {
        System.out.println("Los docentes pueden solicitar equipo de computo, proyectores y aulas");
    }

    @Override
    public int definirAccesos() {
        return 2;
    }

    @Override
    public void realizarFuncionPrinicipal() {
        System.out.println("dicatr clase de manera cuchilla");
    }

    @Override
    protected void protocoloIngreso() {
        System.out.println("Los docentes pueden ingresar por cualquier entrada en horarios de 8 a 10pm");
    }
}
