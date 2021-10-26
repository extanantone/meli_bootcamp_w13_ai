public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {}

    public Persona(String inNombre, int inEdad, String inDni) {
        this.nombre = inNombre;
        this.edad = inEdad;
        this.dni = inDni;
    }

    public Persona(String inNombre, int inEdad, String inDni, double inPeso, double inAltura) {
        this.nombre = inNombre;
        this.edad = inEdad;
        this.dni = inDni;
        this.peso = inPeso;
        this.altura = inAltura;
    }

    public int calcularIMC() {
        double imc = this.peso/(this.altura * this.altura);
        double epsilon = 1e-8;
        if (imc < (20 - epsilon)) return -1;
        else if (imc >= (20 - epsilon) && imc <= (25 + epsilon)) return 0;
        else return 1;
    }

    public boolean esMayorDeEdad() {
        return (this.edad >= 18);
    }

    @Override
    public String toString(){
        String infoPersona = "Nombre: " + this.nombre;
        infoPersona+="\nEdad: " + this.edad;
        infoPersona+="\nDNI: " + this.dni;
        infoPersona+="\nPeso: " + this.peso;
        infoPersona+="\nAltura: " + this.altura;
        return infoPersona;
    }
}
