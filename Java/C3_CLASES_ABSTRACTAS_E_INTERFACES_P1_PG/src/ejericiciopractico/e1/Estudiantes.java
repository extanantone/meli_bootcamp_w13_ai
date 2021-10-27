package ejericiciopractico.e1;

public class Estudiantes extends Persona implements UsuariosUniversidad{

    public Estudiantes(String dni, int edad, String nombre, String apellido, String idUniversidad) {
        super(dni, edad, nombre, apellido, idUniversidad);
    }

    @Override
    public void protocoloIngreso() {
        System.out.println("El estudiante solo ingresa por la puerta prinicpal en horario 8 am a 10 pm");
    }

    @Override
    public void tomarClases(String idAula,int hora) {
        System.out.println("El estudiante se sienta e ingresa al aula: " + idAula + " a las " + hora + " horas");
    }

    @Override
    public void recibirTutorias(String idAula, Persona profesor) {
        System.out.println("El estudiante recibe tutorias del docente: " + profesor.getNombre() + " en el aula: " + idAula);
    }

    @Override
    public void usarInstalaciones(String idInstalacion) {
        System.out.println("Los estudiantes solo pueden usar aulas, baños y laboratorios");
    }
}
