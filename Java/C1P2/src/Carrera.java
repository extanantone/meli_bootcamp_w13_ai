public class Carrera {

    public static void main(String[] args){

        Persona persona1 = new Persona(34315958, "Nicolas", "Bovina", 32, 351662934, 351999999, "A-");
        Persona persona2 =  new Persona( 35505000, "Juan", "Perez", 20, 351887762, 351888888, "B+");
        Persona persona3 = new Persona( 31234589, "Pedro", "Gomez", 24, 351612345, 351777777, "0+" );

        Categoria chico = new Categoria("Chico", 1300, 1500);
        Categoria medio = new Categoria("Medio", 2000, 2300);
        Categoria avanzado = new Categoria("Avanzado", 0, 2800);

        chico.inscribirParticipante(persona1);
        medio.inscribirParticipante(persona2);
        avanzado.inscribirParticipante(persona3);

        chico.mostrarParticipantes();
        medio.mostrarParticipantes();
        avanzado.mostrarParticipantes();

    }
}
