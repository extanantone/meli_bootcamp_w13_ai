package bootcamp;

public class Persona {

    //Atributos
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //Constructores
    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;  //en kg
        this.altura = altura;  //en mts
    }

    //Metodos
    //calcula el indice de masa corporal
    public int cacularIMC(){
        double imc = this.peso/Math.pow(this.altura, 2);
        if(imc < 20){
            return -1;
        }else if(imc > 25){
            return 1;
        }else{ //entre 20 y 25
            return 0;
        }
    }

    //retorna true si la persona es mayor de edad
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona:" + '\n' +
                " - nombre=" + nombre + '\n' +
                " - edad=" + edad + '\n' +
                " - dni=" + dni + '\n' +
                " - peso=" + peso + " kg.\n" +
                " - altura=" + altura + " m.";
    }
}
