package Ejercicio_practico_POO.src;
public class Main {
    public static void main(String[] args){
        Person juan=new Person();
        Person miguel=new Person("Miguel Diaz",23,"57483138");
        Person kevin = new Person("Kevin Suarez", 35, "56488311", 69, 178);
        //Person daniel=new Person("Daniel Guzman",22); Error

        System.out.println("DATOS DEL USUARIO:");
        switch (kevin.calcularMC()){
            case -1:
                System.out.println("El usuario esta bajo de peso");
                break;
            case 0:
                System.out.println("El usuario tiene un peso saludable");
                break;
            case 1:
                System.out.println("El usuario tiene sobrepeso");
                break;
        }
        if(kevin.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("No es mayor de edad");
        }
        System.out.println(kevin.toString());

    }
}
