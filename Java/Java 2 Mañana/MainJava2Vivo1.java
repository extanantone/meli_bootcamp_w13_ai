public class MainJava2Vivo1 {
    public static void main(String[] args) {
        PersonaJava2Vivo1 persona1 = new PersonaJava2Vivo1();
        PersonaJava2Vivo1 persona2 = new PersonaJava2Vivo1("nombre2", 20, "dni2");
        PersonaJava2Vivo1 persona3 = new PersonaJava2Vivo1("nombre3", 20, "dni3", 70.0, 1.70);

        int IMC = persona3.calcularIMC();
        boolean mayorEdad = persona3.esMayorDeEdad();

        switch (IMC){
            case -1 :
                System.out.println(persona3.toString()+" es mayor de edad: "+mayorEdad+" y tiene Bajo peso");
                break;
            case 0 :
                System.out.println(persona3.toString()+" es mayor de edad: "+mayorEdad+" y tiene Peso saludable");
                break;
            case 1 :
                System.out.println(persona3.toString()+" es mayor de edad: "+mayorEdad+" y tiene Sobrepeso");
                break;

        }
    }
}
