package poo;

public class Main {
    public static void main(String[] args) {
        Persona juana = new Persona();
        Persona sofia = new Persona("Sofía", 24, "432432");
        Persona maria = new Persona("María", 30, "0303039", 50, 163);

        int imc = maria.calcularIMC();
        String mensajeIMC;
        if (imc < 0) {
            mensajeIMC = "Tiene bajo peso";
        } else if (imc == 0) {
            mensajeIMC = "Tiene peso saludable";
        } else {
            mensajeIMC = "Tiene sobrepeso";
        }
        String mensajeEdad = maria.esMayorDeEdad() ? " y es mayor de edad" : " y es menor de edad";
        System.out.println(maria.toString() + "\n" + mensajeIMC + mensajeEdad);
    }
}
