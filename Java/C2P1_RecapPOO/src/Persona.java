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

    public int calcularIMC(){
        int resultIMC;
        int imc = (int) (this.peso / (this.altura*this.altura));

        if( imc < 20 ){
            resultIMC = -1;
        }else if( imc >= 20 && imc <= 25 ){
            resultIMC = 0;
        }else{
            resultIMC = 1;
        }
        return resultIMC;
    }

    public boolean esMayorDeEdad(){
        boolean esMayor = false;

        if( this.edad > 17 ){
            esMayor = true;
        }

        return esMayor;
    }
}
