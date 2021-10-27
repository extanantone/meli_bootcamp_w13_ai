package ejericiciopractico.e1;

public class EstudianteTecnico extends Estudiantes implements FuncionariosUniversidad{

    public EstudianteTecnico(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        super(dni, edad, nombre, apellido, idUniversidad);
    }

    @Override
    public void obtenerEquipos() {
        System.out.println("pueden solicitar acceso a datacenter");
    }

    @Override
    public int definirAccesos() {
        return 2;
    }

    @Override
    public void realizarFuncionPrinicipal() {
        System.out.println("auydar en mantenimientos complicados");
    }

}
