public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 29, "1017202476");
        Persona persona3 = new Persona("Pedro", 30, "98487799", 105.0f, 1.84f);
        
        System.out.println("Nombre: "+ persona1.getNombre());
        persona1.setNombre("Juan David Ortiz");
        System.out.println("Nombre: " + persona1.getNombre());
    }
}
