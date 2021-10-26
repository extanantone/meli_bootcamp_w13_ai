package Ejercicio_practico_POO.src;
public class Person {
    public String nombre;
    public int edad;
    public String dni;
    public double peso;
    public double altura;

    public Person() {
    }

    public Person(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Person(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularMC(){
        double mc=this.peso/Math.pow(altura,2);
        if(mc<20){
            return -1;
        }
        if(mc>=20 && mc<=25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad>=18? true:false;
    }

    @Override
    public String toString() {
        return "informacion personal: {" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
