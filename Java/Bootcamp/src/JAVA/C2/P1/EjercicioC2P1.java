package JAVA.C2.P1;

public class EjercicioC2P1 {
    public static void main(String[] args) {
        persona p1 = new persona("Marina", 25, "39620502", 56.7, 155);
        persona p2 = new persona("Fabrizio", 24);

        System.out.println("El IMC de la persona es: " + p1.calcularIMC());
        if (p1.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona no es mayor de edad.");
        }

        System.out.println(p1.toString());
    }
}
