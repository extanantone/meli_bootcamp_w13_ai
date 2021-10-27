public class Persona {

    //Atributos de la clase
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //Metodos de la clase
    public String getNombre(){return nombre;}
    public int getEdad(){return edad;}
    public void setNombre(String nombre){this.nombre= nombre;}
    //Constructor con todos los parametros
    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    //Construcctor por defecto
    public Persona() {
        nombre="Sin definir";

    }
    public Persona (String nombre, int  edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public int calcularIMC(){
        double IMC = this.peso/(this.altura*this.altura);
        if (IMC < 20){
            return -1;
        }
        else if (IMC >= 20 && IMC <=25){
            return 0;
        }
        else {
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        if (this.getEdad() <= 18){
            return false;
        }
        else {
            return true;
        }
    }

}

