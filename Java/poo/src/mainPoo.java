public class mainPoo {
    public static void main (String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("diana",22,"1234");
        Persona persona3 = new Persona("camilo", 25, "1456", 90, 1.70);
        int imc=persona3.calcularIMC();
        if(imc==-1){
            System.out.println("El IMC de la persona es menor a 20 es decir esta bajo de peso");
        }else if(imc == 0){
            System.out.println("El IMC de la spersona esta entre 20 y 25, es decir tiene un peso saludable");
        }else{
            System.out.println("El IMC de la persona es mayor a 25, es decir que esta en sobrepeso");
        }
        boolean mayor = persona3.esMayorDeEdad();
        if(mayor){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }
    }
}
