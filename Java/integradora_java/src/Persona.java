public class Persona {
    String nombre;
    short edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
        System.out.println("Se creo una persona\n");
    }

    public Persona(String nombre, short edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        System.out.println("Se creo una persona:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("DNI: " + dni + "\n");
    }

    public Persona(String nombre, short edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;

        System.out.println("Se creo una persona:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("DNI: " + dni);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura + "\n");
    }

    public int cacularIMC(){
        double valor = (this.peso/(this.altura*this.altura));
        return (valor < 20) ? -1 : ((valor >= 20 && valor <= 25) ? 0 : 1);
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
    }

    public String toString() {
        return  "Nombre: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "DNI: " + dni + '\n' +
                "Peso: " + peso + '\n' +
                "Altura: " + altura;
    }
}
