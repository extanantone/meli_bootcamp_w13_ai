

public class Main {
    public static void main(String[] args){
        Persona persona_inicializada = new Persona();
        Persona persona_info_general = new Persona("Jhoan",27,"101909323");
        Persona persona_full_info = new Persona("juan",20,"1234568",64,175);

       int datoIMC = persona_full_info.calcularIMC();

       if(datoIMC == 0) {
           System.out.println("El usuario " + persona_full_info.nombre + " tiene bajo peso");
       } else if (datoIMC == 1) {
           System.out.println("El usuario " + persona_full_info.nombre + " tiene un peso saludable");
       } else {
           System.out.println("El usuario " + persona_full_info.nombre + " tiene sobrepeso");
       }

       if(persona_full_info.esMayorDeEdad()){
           System.out.println("El usuario " + persona_full_info.nombre + " es mayor de edad");
       } else {
           System.out.println("El usuario " + persona_full_info.nombre + " es menor de edad");
       }

        System.out.println(persona_full_info.toString());

    }
}
