public class Persona {
    String nombre;
    int edad;
    int dni;
    double peso;
    double altura;


    public Persona(String nombre, int edad, int dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(){


    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public int calcularMC(){
        double mc =  peso / Math.pow(altura, 2);
        if (mc < 20 ) {
            return -1;
        } else  if (  mc <= 25 ) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        if (edad >= 18){
            return true;
        }
        return  false;
    }

    public String toString(){
        return  "Nombre "+ nombre + " dni " + dni + " edad " + edad + " altura "+ altura + " peso " + peso;
    }



}
