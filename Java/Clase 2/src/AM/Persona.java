package AM;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double IMC = peso / Math.pow(altura, 2);
        int retorno;

        if (IMC < 20) {
            retorno = -1;
        } else if (IMC >= 20 && IMC <= 25) {
            retorno = 0;
        } else {
            retorno = 1;
        }

        return retorno;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        String enter = System.getProperty("line.separator");
        return String.format(
                "Los datos con los que contamos son los siguientes:" + enter +
                        "• Nombre: " + nombre + enter +
                        "• Edad: " + edad + enter +
                        "• DNI: " + dni + enter +
                        "• Peso: " + peso + "kg." + enter +
                        "• Altura: " + altura + "mts."
        );
    }
}