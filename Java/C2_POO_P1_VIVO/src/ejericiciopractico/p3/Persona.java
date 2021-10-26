package ejericiciopractico.p3;

public class Persona{

    String nombre;
    int edad;
    double peso;
    String dni;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, double peso, String dni, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.dni = dni;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso/(this.altura*this.altura);
        if(imc<20)
            return -1;
        else if(imc>=20 && imc<=25)
            return 0;
        else
            return 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Datos Personales = {" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", analisis Peso =" + analisisPeso() + '\'' +
                ", es mayor de Edad? = " + (esMayorDeEdad()?"Si":"No") + '\'' +
                '}';
    }

    public String analisisPeso(){
        int resImc = calcularIMC();
        if(resImc<0)
            return "Bajo Peso";
        else if(resImc==0)
            return "Peso saludable";
        else
            return "Sobrepeso";
    }
}