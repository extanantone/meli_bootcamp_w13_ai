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

    //CALCULAR INDICE DE IMC
    void calcularIMC(){
        int indice = 0;
        double calculo = peso / (altura * altura);

        if (calculo < 20){
            System.out.println("La persona tiene bajo peso");
        }
        else {
            if (calculo >= 20 || calculo <= 25){
                System.out.println("La persona se encuentra dentro del rango ideal de peso");

            }
            else {
                System.out.println("La persona tiene sobrepeso");
            }
        }
    }

    //CALCULAR MAYORIA DE EDAD
    void esMayorDeEdad(){
        if (this.edad > 18){
            System.out.println("La persona es mayor de edad");
        }
        else {
            System.out.println("La persona es menor de edad");
        }
    }

    @Override
    public String toString() {
        this.esMayorDeEdad();
        this.calcularIMC();
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
