public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura; //En metros

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso / (this.altura * this.altura);
        if (imc < 20) {
            return -1;
        } else {
            if (imc > 25) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString(){
        String persona = "Nombre: "+this.nombre+" Edad: "+this.edad+" DNI: "+this.dni+" Peso: "+this.peso+" Altura: "+this.altura;
        return persona;
    }
}
