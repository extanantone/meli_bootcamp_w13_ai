public class PersonaJava2Vivo1 {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public PersonaJava2Vivo1() {
    }

    public PersonaJava2Vivo1(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public PersonaJava2Vivo1(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double IMC = this.peso / (this.altura * this.altura);
        if (IMC < 20){
            return -1;
        }else if (IMC >= 20 && IMC <= 25){
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad (){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Datos de la persona: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura ;
    }
}
