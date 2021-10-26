public class Main {
    public static void main (String[] args) {
        Persona sujeto = new Persona();
        Persona juanma = new Persona("Juan Manuel", 22, "40923921");
        Persona ana = new Persona("Ana", 35, "27467323", 65.09, 1.75);

        // Persona juanCarlos = new Persona("Juan Carlos", 51); -> No hay constructor en la clase que se pueda llamar de esta forma

        System.out.println("¿Cuál es el nivel de peso de Ana en base a su IMC?");
        int nivelDePeso = ana.calcularIMC();
        switch(nivelDePeso) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
        }

        System.out.println("¿Es Ana mayor de edad?");
        if (ana.esMayorDeEdad()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }

        System.out.println("¿Cuáles son los datos de Ana?");
        System.out.println(ana.toString());

        System.out.println("Veamos también los datos de los otros sujetos creados para evitar warnings :)");
        System.out.println(sujeto.toString());
        System.out.println(juanma.toString());
    }
}
