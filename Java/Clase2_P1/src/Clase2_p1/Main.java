package Clase2_p1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("nombre", 25, "dni2");
        Persona persona3 = new Persona("nombre1", 25, "dni3", 70.0, 1.80);

        System.out.println(persona3);

        int imc = persona3.calcularIMC();

        if(imc == -1){
            System.out.println("Tu peso es bajo");
        }else{
            if(imc ==0){
                System.out.println("Tu peso es saludable");
            }else{
                System.out.println("Tienes sobrepeso");
            }
        }
        if (persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }

}
