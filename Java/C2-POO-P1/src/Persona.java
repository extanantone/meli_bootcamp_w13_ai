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
        double imc = this.peso/Math.pow(this.altura,2);
        if (imc < 20){
            return -1;
        } else if (imc >= 20 && imc <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public static void toString(Persona p){
        String info = "===========================\n";
        info += "INFORMACION DE LA PERSONA: \n";
        info += "===========================\n";
        info += "Nombre: " + p.nombre + "\n";
        info += "Edad: " + p.edad + "\n";
        info += "DNI: " + p.dni + "\n";
        info += "Peso: " + p.peso + "\n";
        info += "Altura: " + p.altura;
        System.out.println(info);
    }

}
