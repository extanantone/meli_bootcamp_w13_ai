package bootcamp;

public class Main {

    public static void main(String[] args) {

        Persona juan = new Persona();
        Persona pablo = new Persona("pablo perez", 21, "43.055.123");
        Persona martin = new Persona("martin suarez", 44, "23.444.555", 77, 1.76);

       // Persona personaIncompleta = new Persona("incompleta", 15);

        System.out.println(martin.toString());
        String resultIMC = "";
        switch (martin.cacularIMC()){
            case 0:
                resultIMC = "Peso saludable";
                break;
            case 1:
                resultIMC = "Sobrepeso";
                break;
            case -1:
                resultIMC = "Bajo peso";
                break;
        }
        System.out.println("Índice de masa corporal (IMC): " + resultIMC);

        System.out.print("¿Cumple mayoría de edad? ");
        System.out.println((martin.esMayorDeEdad())? "Si" : "No");

    }
}
