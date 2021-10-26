import jdk.swing.interop.SwingInterOpUtils;

public class EjercicioC2P1 {
    public static void main (String[] args){
        PersonaC2P1 p1 = new PersonaC2P1("Marina", 25, "39620502", 56.7, 155 );
        PersonaC2P1 p2 = new PersonaC2P1("Fabrizio", 24);

        System.out.println("El IMC de la persona es: " + p1.calcularIMC());
        if (p1.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad.");
        }
        else{
            System.out.println("La persona no es mayor de edad.");
        }

        System.out.println(p1.toString());
    }
}
