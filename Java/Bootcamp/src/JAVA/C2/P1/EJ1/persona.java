package JAVA.C2.P1.EJ1;

//tuve que crear la clase en minúscula porque intelijj me tiraba error con "Persona".
public class persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    int altura;

    public persona() {

    }

    public persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public persona(String nombre, int edad, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int calcularIMC() {
        double imc = this.peso / (Math.pow(this.altura, 2));
        if (imc < 20) {
            return -1;
        } else if (imc > 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Los datos de la persona son: " + "\n" +
                "Nombre:'" + nombre + "\n" +
                "Edad:" + edad + "\n" +
                "DNI:'" + dni + "\n" +
                "Peso:" + peso + "\n" +
                "Altura:" + altura;
    }
}
