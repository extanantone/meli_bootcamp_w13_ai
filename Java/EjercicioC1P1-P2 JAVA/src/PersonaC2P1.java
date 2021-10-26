public class PersonaC2P1 {
    String nombre;
    int edad;
    String dni;
    double peso;
    int altura;

    public PersonaC2P1(){

    }

    public PersonaC2P1(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public PersonaC2P1(String nombre, int edad, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public PersonaC2P1(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int calcularIMC(){
        double imc = this.peso/(Math.pow(this.altura,2));
        if (imc<20){
            return -1;
        }
        else if(imc>20&&imc<=25){
            return 0;
        }
        else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad>=18){
            return true;
        }
        else{
            return false;
        }
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
