public class Inicio {
    public static void main(String[] args) {
        Person persona1 = new Person();
        Person persona2 = new Person("Federico",12,"39.670.223");
        Person persona3 = new Person("Federico2",32,"3",80,1.70);


        int imc = persona3.calcularIMC();
        if (persona3.esMayorDeEdad() == true) {
            switch (imc) {
                case 0:
                    System.out.println(persona3.toString() + "" + persona3.esMayorDeEdad() + " Tenes un Peso saludable");
                    break;
                case 1:
                    System.out.println(persona3.toString() + "" + persona3.esMayorDeEdad() + " Tenes Sobre peso");
                    break;
                case -1:
                    System.out.println(persona3.toString() + "" + persona3.esMayorDeEdad() + " Tenes un Bajo peso");
                    break;
                default:
                    System.out.println("No encontrado");
                    break;
            }
        }else{
            System.out.println("Sos menor de edad, no puedo realizar un chekeo");
        }
    }
}
