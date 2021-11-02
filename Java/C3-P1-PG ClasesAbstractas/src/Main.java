import Ejercicio.*;

public class Main {
    public static void main(String[] args){
        Estudiante mEstudiante= new Estudiante("Pedro", "Perez", "Estudiante");
        Estudiante mEstudiante2= new Estudiante("Pedro", "Perez", "Tutor");
        Estudiante mEstudiante3= new Estudiante("Pedro", "Perez", "Tecnico");
        Profesor mProfesor= new Profesor();
        PersonalAdministrativo mPersonalAdministrativo= new PersonalAdministrativo();
        PersonalDeAseo mPersonalDeAseo= new PersonalDeAseo();

        System.out.println(mEstudiante.toString());
        System.out.println(mEstudiante.dictarClase());
        System.out.println(mEstudiante.prestarSoporte());
        System.out.println(mEstudiante2.toString());
        System.out.println(mEstudiante2.dictarClase());
        System.out.println(mEstudiante2.prestarSoporte());
        System.out.println(mEstudiante3.toString());
        System.out.println(mEstudiante3.dictarClase());
        System.out.println(mEstudiante3.prestarSoporte());
    }
}
