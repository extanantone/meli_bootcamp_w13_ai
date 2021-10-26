public class Main {

    public static void main(String[] args) {

        Persona personaConstruidaSinParametros = new Persona();
        Persona personaConDniNombreEdad = new Persona("Juan", 25, "12345678");
        Persona personaConTodosLosParametros = new Persona ("Carlos", 30, "12345679", 78, 1.83);

        /** Este constructor da error porque no tenemos definido un constructor que reciba
         * como parámetro solo el nombre y la edad
         *
         * Persona personaConError = new Persona("Jorge", "35");
         */

        String IMC = personaConTodosLosParametros.calcularIMC();
        System.out.println("Tu IMC es " + IMC);

        Boolean esMayor = personaConTodosLosParametros.esMayorDeEdad();

        if(esMayor)
            System.out.println("La persona es mayor de edad");
        else
            System.out.println("La persona no es mayor de edad");

        System.out.println(personaConTodosLosParametros.toString());

    }
}
