package CarreraDeLaSelva;

public class Main {
    public static void main(String[] args) {
        Participante p1 = new Participante(
                36281928,
                "Mayra",
                "Picone",
                0303456,
                "B+",
                1166992283,
                21
        );

        Participante p2 = new Participante(
                33567965,
                "Armando",
                "Paredes",
                0303456,
                "A+",
                11273723,
                17
        );

        Participante p3 = new Participante(
                17556728,
                "Esteban",
                "Quito",
                0303456,
                "0+",
                1133542283,
                33
        );

        Participante p4 = new Participante(
                35333928,
                "Raul",
                "Taibo",
                0303456,
                "A+",
                11778773,
                28
        );

        Carrera carrera = new Carrera();

        System.out.println(carrera.subscripcion("chico", p1));
        System.out.println(carrera.subscripcion("chico", p2));
        System.out.println(carrera.subscripcion("medio", p3));
        System.out.println(carrera.subscripcion("avanzado", p4));

        carrera.mostrarParticipantes();
    }
}