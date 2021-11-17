public class Main {
    public static void main(String[] args) {
        Persona lorenzo = new Persona();
        Persona tomas = new Persona("lorenzo", 24, "40229443");
        Persona jose = new Persona("jose", 23, "42424242", 73.4, 1.72);

        jose.calcularIMC();
        jose.esMayorDeEdad();
        System.out.println(jose.toString());
    }
}
