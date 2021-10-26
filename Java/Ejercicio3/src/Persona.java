public class Persona {

    //Atributos de la clase
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    //Metodos de la clase
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre= nombre;}
    //Constructor con todos los parametros
    public Persona(String nombre, int edad, String dni, float peso, float altura){
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
    //Método principal
    public static void main(String[] args) {
        Persona p1 = new Persona();
        System.out.println("Nombre: "+ p1.getNombre());
        p1.setNombre("Juan David Ortiz");
        System.out.println("Nombre: " + p1.getNombre());
    }
}
