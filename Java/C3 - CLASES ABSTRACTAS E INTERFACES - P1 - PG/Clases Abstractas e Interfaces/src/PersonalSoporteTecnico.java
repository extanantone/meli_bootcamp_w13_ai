public class PersonalSoporteTecnico extends Persona implements DarSoporte{
    private String cargo;

    @Override
    public void darSoporte() {
        System.out.println("Soporte por personal de soporte tecnico");
    }
}
