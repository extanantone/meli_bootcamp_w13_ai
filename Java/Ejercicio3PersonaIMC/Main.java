public class Main {

    public static void main(String[] args) {

        Persona personaVacio = new Persona();

        Persona persona = new Persona("Juan", 26,"10103049");

        Persona personaCompleto = new Persona("David", 27,"10204920",74.5,175.5);

        System.out.println(personaCompleto);

        int imc = personaCompleto.calcularIMC();

        if(imc==-1){
            System.out.println("Nivel de Peso : Bajo");
        }else{
            if(imc==0){
                System.out.println("Nivel de Peso : Saludable");
            }else{
                System.out.println("Nivel de Peso : Sobrepeso");
            }
        }

        if(personaCompleto.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }

    }
}
