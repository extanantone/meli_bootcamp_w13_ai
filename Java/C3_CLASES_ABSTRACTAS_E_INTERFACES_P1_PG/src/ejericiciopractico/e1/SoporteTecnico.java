package ejericiciopractico.e1;

public class SoporteTecnico extends Persona implements FuncionariosUniversidad{

    public SoporteTecnico(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        super(dni, edad, nombre, apellido, idUniversidad);
    }

    @Override
    public void obtenerEquipos() {
        System.out.println("El area de sporte tecnico puede entrar al datacenter y solicitar terminales de computo");
    }

    @Override
    public int definirAccesos() {
        return 1;
    }

    @Override
    public void realizarFuncionPrinicipal() {
        System.out.println("realziar amntenimiento ocmplicado");
    }

    @Override
    protected void protocoloIngreso() {
        System.out.println("cualquier peurta cualquier horario");
    }
}
