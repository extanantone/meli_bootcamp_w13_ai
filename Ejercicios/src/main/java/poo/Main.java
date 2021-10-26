package poo;

public class Main {

    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaDniNombreEdad = new Persona("Armando", 48, "17556702");
        Persona personaTodosLosParametros = new Persona ("Puentes", 33, "33366779", 78, 1.83);

        // Persona personaConError = new Persona("Marcos", "33");


        String IMC = personaTodosLosParametros.calcularIMC();
        System.out.println("Tu IMC es " + IMC);

        Boolean esMayor = personaTodosLosParametros.esMayorDeEdad();

        if(esMayor)
            System.out.println("La persona es mayor de edad");
        else
            System.out.println("La persona no es mayor de edad");

        System.out.println(personaTodosLosParametros.toString());

    }
}