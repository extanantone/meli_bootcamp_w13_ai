public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

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
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC(){
        double MC = this.peso/Math.pow(this.altura,2) ;
        int retorno =1;
        if(MC < 20){
            retorno =-1;
        }else if(MC>=20 && MC <=25){
            retorno =0;
        }
        return retorno;
    }
    public boolean esMayorDeEdad(){
        boolean retorno = false;
        if(this.edad >=18){
            retorno = true;
        }
        return retorno;
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
