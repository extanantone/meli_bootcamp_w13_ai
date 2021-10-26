public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){
        this.nombre= "NN";
        this.edad= 18;
        this.dni= "0000";
        this.peso= 68.8;
        this.altura= 1.8;
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre= nombre;
        this.edad= edad;
        this.dni= dni;
        this.peso= 68.8;
        this.altura= 1.8;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura ){
        this.nombre= nombre;
        this.edad= edad;
        this.dni= dni;
        this.peso= peso;
        this.altura= altura;
    }

    public double calcularIMC(){
        double response= this.peso/(Math.pow(this.altura, 2));
        if (response < 20)
            return -1;
        else if (response>=20 && response>=25)
            return 0;
        else
            return 1;
    }

    public boolean esMayorDeEdad(){
        if (this.edad >=18)
            return true;
        else
            return false;
    }

    public String toString(){
        String info= "El nombre es: " + this.nombre +
                ". La edad es= " + this.edad +
                ". El DNI= " + this.dni +
                ". Su altura es= " + this.altura +
                ". Su peso es= " + this.peso;

        return info;
    }
}
