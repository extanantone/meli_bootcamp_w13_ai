package ejericiciopractico.e1;

public class Main {

    public static void main(String[] args) {

        // creo los registros de este año

        Docente pablo = new Docente("12",24,"Pablo","Gomez", "1");
        Docente pedro = new Docente("122",35,"Pedro","Gomez", "2");
        Estudiantes angulo = new Estudiantes("123",18,"Angulo","Springfield", "3");
        EstudianteTecnico jose = new EstudianteTecnico("125",24,"Jose","Gomez", "4");
        SoporteTecnico maria = new SoporteTecnico("126",25,"Maria","Alvarez","5");
        EstudianteTutor miguel = new EstudianteTutor("127",26,"Miguel","Alvarez","6");

        jose.obtenerEquipos();
        jose.getNombre();
        jose.tomarClases("12",3);
        miguel.tomarClases("1",5);
        miguel.realizarFuncionPrinicipal();





    }

}
