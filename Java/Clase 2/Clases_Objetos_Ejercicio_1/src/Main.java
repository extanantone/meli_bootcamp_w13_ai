public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona1 = new Persona("manuel",12,"1234");
        Persona persona2 = new Persona("edvard",23,"23",80,170);

        System.out.println("La persona se llama:"+persona2.nombre);
        if(persona2.esMayorDeEdad()){
            System.out.println("Es Mayor de edad");
        }else{
            System.out.println("No es Mayor de edad");
        }
        if (persona2.calcularIMC()==-1){
            System.out.println("La persona esta baja de peso");

        }else if(persona2.calcularIMC()==0){
            System.out.println("La persona esta baja de peso");

        }else if(persona2.calcularIMC()==1){
            System.out.println("La persona tiene sobre peso");

        }

    }
}
