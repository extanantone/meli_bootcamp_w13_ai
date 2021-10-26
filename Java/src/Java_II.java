public class Java_II {
        public static class Persona{
                String nombre;
                int edad;
                int dni;
                double peso;
                double altura;
                public Persona(){}
                public Persona(String nombre, int edad, int dni){
                        this.nombre = nombre;
                        this.edad = edad;
                        this.dni = dni;
                }
                public Persona(String nombre, int edad, int dni, double peso, double altura) {
                        this.nombre = nombre;
                        this.edad = edad;
                        this.dni = dni;
                        this.peso = peso;
                        this.altura = altura;
                }
                public int calcularIMC(){
                        double imc = (peso/(altura * altura));
                        int forReturn = 0;
                        if(imc < 20) {forReturn = -1;}
                        if(imc > 25) {forReturn = 1;}
                        return forReturn;
                }
                public boolean esMayorDeEdad(){
                        return edad > 17;
                }
                @Override
                public String toString() {
                        return
                                nombre + ":" +
                                " edad=" + edad +
                                ", dni=" + dni +
                                ", peso=" + peso +
                                ", altura=" + altura
                                ;
                }
        }
        public static void main(String[] args) {
                Persona personaVacia = new Persona();
                Persona personaSemi = new Persona("Jhon Due",30,30987279);
                Persona personaCompleta = new Persona("Jhon Doe",23,3456789,53.00,1.70);
                System.out.println(personaCompleta);
                switch (personaCompleta.calcularIMC()){
                        case -1:
                                System.out.println("Bajo de peso");
                               break;
                        case 0:
                                System.out.println("Saludable");
                                break;
                        case 1:
                                System.out.println("Sobrepeso");
                                break;
                        default:
                                break;
                }
                System.out.println(personaCompleta.esMayorDeEdad()?"Es mayor de edad":"Es menor de edad");
        }
}
