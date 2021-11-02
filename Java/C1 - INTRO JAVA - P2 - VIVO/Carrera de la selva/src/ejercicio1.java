import java.util.*;

public class ejercicio1 {

    public static void main(String[] args) {
        List<Persona> circuitoChico = new ArrayList<Persona>();
        List<Persona> circuitoMedio = new ArrayList<Persona>();
        List<Persona> circuitoAvanzado = new ArrayList<Persona>();
        HashMap<Integer, Integer> inscriptos = new HashMap<>();

        //Datos circuitoChico
        circuitoChico.add(
                new Persona(
                        39931001,
                        "Thiago",
                        "Almada",
                        20,
                        15123456,
                        112233,
                        "O+"
                )
        );
        inscriptos.put(39931001, 1);
        circuitoChico.add(
                new Persona(
                        39931002,
                        "Pedro",
                        "De la Vega",
                        20,
                        15654321,
                        223344,
                        "B-"
                )
        );
        inscriptos.put(39931002, 1);
        circuitoChico.add(
                new Persona(
                        39931003,
                        "Julian",
                        "Alvarez",
                        21,
                        15234567,
                        334455,
                        "A-"
                )
        );
        inscriptos.put(39931003, 1);
        //Datos circuitoMedio
        circuitoMedio.add(
                new Persona(
                        39931004,
                        "Franco",
                        "Armani",
                        34,
                        15345678,
                        445566,
                        "A+"
                )
        );
        inscriptos.put(39931004, 2);
        circuitoMedio.add(
                new Persona(
                        39931005,
                        "Angel",
                        "Di Maria",
                        34,
                        15456789,
                        556677,
                        "B-"
                )
        );
        inscriptos.put(39931005, 2);
        circuitoMedio.add(
                new Persona(
                        39931006,
                        "Sergio",
                        "Aguero",
                        34,
                        15567890,
                        667788,
                        "A-"
                )
        );
        inscriptos.put(39931006, 2);
        //Datos circuitoAvanzado
        circuitoAvanzado.add(
                new Persona(
                        39931007,
                        "Leo",
                        "Messi",
                        34,
                        15445566,
                        334455,
                        "A+"
                )
        );
        inscriptos.put(39931007, 3);
        circuitoAvanzado.add(
                new Persona(
                        3993108,
                        "Rodrigo",
                        "De Paul",
                        27,
                        15667788,
                        556677,
                        "B-"
                )
        );
        inscriptos.put(39931008, 3);
        circuitoAvanzado.add(
                new Persona(
                        39931009,
                        "Emiliano",
                        "Martinez",
                        29,
                        15556677,
                        445566,
                        "A-"
                )
        );
        inscriptos.put(39931009, 3);

        Persona nuevaPersona = new Persona(
                39931241,
                "Jorge",
                "Miño",
                25,
                15674061,
                335301,
                "A+"
        );
        int categoria = 3;
        int monto = 0;
        if (inscriptos.get(nuevaPersona.getDni()) == null){
            switch (categoria){
                case 1:
                    circuitoChico.add(nuevaPersona);
                    inscriptos.put(nuevaPersona.getDni(), 1);
                    monto = nuevaPersona.getEdad() < 18 ? 1300 : 1500;
                    System.out.println("Monto a pagar: $"+monto);
                    break;
                case 2:
                    circuitoMedio.add(nuevaPersona);
                    inscriptos.put(nuevaPersona.getDni(), 2);
                    monto = nuevaPersona.getEdad() < 18 ? 2000 : 2300;
                    System.out.println("Monto a pagar: $"+monto);
                    break;
                case 3:
                    if (nuevaPersona.getEdad() > 18) {
                        circuitoAvanzado.add(nuevaPersona);
                        inscriptos.put(nuevaPersona.getDni(), 3);
                        System.out.println("Monto a pagar: $2800");
                    } else {
                        System.out.println("La categoria no permite inscripciones para menores de 18");
                    }
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("La persona ya se encuentra inscripta");
        }

        System.out.println("---Mostrando participantes circuito avanzado-----");
        int numero_inscripcion = circuitoChico.size() + circuitoMedio.size() + 1;
        for(int index = 0; index < circuitoAvanzado.size(); index ++) {
            System.out.print("Numero de inscripcion: "+(numero_inscripcion + index)+" ");
            System.out.println(circuitoAvanzado.get(index));
        }
        System.out.println("-------------------------------------------------");

        System.out.println("---Describiendo a participante de circuito avanzado-----");
        System.out.println(circuitoAvanzado.get(0));
        System.out.println("-------------------------------------------------");
    }
}
