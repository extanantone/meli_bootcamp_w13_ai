public class Person {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Person(){}

    public Person(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public Person(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double IMC = this.peso / (this.altura * this.altura);
        if(IMC < 20){
            return -1;
        }else if(IMC >= 20 && IMC <= 25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if(this.edad >= 18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Hola" +
                " " + nombre + '\'' +
                ", tu edad es =" + edad +
                ", tu dni='" + dni + '\'' +
                ", tu peso=" + peso +
                ", tu altura=" + altura ;
    }
}
