public class Main {

    public static void main(String[] args) {

        Persona personaSimple = new Persona();
        Persona personaMedia = new Persona("David", 24, "1022426553");
        Persona personaCompleja = new Persona("Mona", 11, "123456", 20.0, 1.20);

        System.out.println("El IMC de la Persona con nombre: " + personaCompleja.getNombre() + " es de: " + personaCompleja.calcularIMC());
        if (personaCompleja.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        System.out.println("Sus datos personales son: " + personaCompleja.toString());

    }
}
