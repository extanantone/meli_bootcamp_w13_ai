package C3.noche;

public class Main {
    public static void main(String[] args) {

        Persona personaUno = new Profesor("Pedro","33444",111);
        System.out.println(personaUno.saludar());
        Persona personaDos = new Tutor("Laura", "333444","2022443");
        System.out.println(personaDos.saludar());
        Estudiante personaTres = new EstudianteTecnico("Marco","8833","2022444333");
        System.out.println(personaTres.saludar());

    }
}
