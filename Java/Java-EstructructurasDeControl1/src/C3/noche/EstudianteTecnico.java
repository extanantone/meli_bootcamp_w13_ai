package C3.noche;

public class EstudianteTecnico extends Estudiante{

    public EstudianteTecnico(String nombre, String dni, String codigoEstudiante) {
        super(nombre, dni, codigoEstudiante);
    }

    @Override
    public void funcionEstudiante() {
        System.out.println("Seleccionado para colaborar en el soporte técnico");
    }

    @Override
    public String saludar() {
        return super.saludar() + " .Colaboro con soporte técnico";
    }
}
