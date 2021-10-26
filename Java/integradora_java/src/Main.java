public class Main {
    public static void main(String[] args) {
        Persona empty = new Persona();
        Persona santiago = new Persona("Santiago",(short) 27,"38294433");
        Persona facundo = new Persona("Facundo",(short) 19,"4384952",50,1.75);

//        Persona marco = new Persona("Marco",(short) 21);
//        esto no es posible, arroja un error diciendo que no se encontro un constructor

        int imc = facundo.cacularIMC();
        System.out.println("Segun el IMC " + facundo.nombre + ((imc == 0) ? " Tiene un peso saludable" : ((imc == 1) ? " Tiene sobrepeso" : " Tiene un peso bajo")));

        System.out.println(facundo.nombre + (facundo.esMayorDeEdad() ? " es mayor de edad" : " es menor de edad"));

        System.out.println(facundo.toString());
    }
}
