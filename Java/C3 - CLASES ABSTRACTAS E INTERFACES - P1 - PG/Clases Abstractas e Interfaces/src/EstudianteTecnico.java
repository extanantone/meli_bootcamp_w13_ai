public class EstudianteTecnico extends Estudiante implements DarSoporte{

    @Override
    public void darSoporte() {
        System.out.println("Soporte provisto por estudiante");
    }
}
