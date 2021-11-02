public class Main {
    public static void main(String[] args) {
        Persona neymar = new Persona();
        Persona leo = new Persona(
                "Leo",
                34,
                "39931000"
        );
        Persona cristiano = new Persona(
                "Cristiano",
                35,
                "39931001",
                80,
                1.84
        );

        System.out.println("Persona: ");
        System.out.println(cristiano);
        System.out.println("¿Es mayor de edad? "+(cristiano.esMayorDeEdad() ? "Si" : "No"));
        String imc = "";
        switch (cristiano.calcularIMC()){
            case -1: imc="Bajo peso";
                break;
            case 0: imc = "Peso saludable";
                break;
            case 1: imc = "Sobrepeso";
                break;
            default: imc = "No se pudo calcular IMC";
                break;
        }
        System.out.println("IMC: "+imc);
    }
}
