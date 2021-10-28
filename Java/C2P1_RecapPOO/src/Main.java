public class Main {
    public static void main(String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro", 23, "1234");
        Persona persona3 = new Persona("Camilo", 67, "987", 70, 1.90);

        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());

        //Imprimir el IMC
        if( persona3.calcularIMC() == -1 ){
            System.out.println("Bajo Peso");
        }else if( persona3.calcularIMC() == 0 ){
            System.out.println("Peso saludable");
        }else{
            System.out.println("Sobrepeso");
        }

        //Imprimir si es mayor de edad
        if(persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }
}
