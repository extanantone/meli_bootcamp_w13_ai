public class Main {
    public static void main(String[] args){
        Persona basico= new Persona();
        //Persona error= new Persona("Error Errores", 18); Esto no se puede pue sno hay un constructor
        Persona andres= new Persona("Andres Morales", 21, "1001");
        Persona carlos= new Persona("Carlos Betancour", 21, "1001", 67.1, 1.72);

        System.out.println("El IMC arrojo un resultado de: " + carlos.calcularIMC());

        if (carlos.esMayorDeEdad())
            System.out.println("El usuario " + carlos.nombre + "es mayor de edad.");
        else
            System.out.println("El usuario " + carlos.nombre + "es menor de edad.");

        System.out.println("Los datos del usuario son: " + carlos.toString());
    }
}
