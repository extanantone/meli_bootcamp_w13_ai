public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

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

    public double calcularIMC(){
        double imc = this.peso/Math.pow(this.altura,2);
        if (imc < 20.0){
            return -1;
        } else if (imc >= 20.0 || imc <= 25.0){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public String toString(){
        StringBuilder persona = new StringBuilder();
        persona.append("Nombre: ");
        persona.append(this.nombre);
        persona.append("\n");
        persona.append("Edad: ");
        persona.append(this.edad);
        persona.append("\n");
        persona.append("DNI: ");
        persona.append(this.dni);
        persona.append("\n");
        persona.append("Peso: ");
        persona.append(this.peso);
        persona.append("\n");
        persona.append("Altura: ");
        persona.append(this.altura);
        return persona.toString();
    }
}
