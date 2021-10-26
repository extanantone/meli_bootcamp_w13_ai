public class Persona {

    String nombre, dni;
    short edad;
    double peso, altura;

    public Persona() {
        System.out.println("Se ha creado una persona.");
    }

    public Persona(String nombre, short edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        System.out.println("Se ha creado la persona " + this.nombre);
    }

    public Persona(String nombre, short edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
        System.out.println("Se ha creado la persona " + this.nombre);
    }

    public int calcularIMC() {
        double imc = this.peso / Math.pow(this.altura, 2);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayor(){
        return(this.edad >= 18);
    }

    /*@Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }*/

    public String evaluarPeso(){
        int resultadoIMC = calcularIMC();
        if(resultadoIMC == -1){
            return "Bajo peso";
        }else if(resultadoIMC == 0){
            return "Peso saludable";
        }else if(resultadoIMC == 1){
            return "Sobre peso";
        }else{
            return "Los resultados no corresponden.";
        }
    }
}
