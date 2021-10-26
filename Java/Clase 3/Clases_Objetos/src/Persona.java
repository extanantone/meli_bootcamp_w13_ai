public class Persona {
    String nombre;
    int edad;
    String dni;
    int peso, altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    int calcularIMC(){
        double imc;
        imc = this.peso/(this.altura*this.altura);
        if (imc<20){
            return -1;
        }else if (imc<25 && imc>20){
            return 0;
        }else{
            return 1;
        }
    }
    boolean esMayorDeEdad(){
        if (this.edad>=18){
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
