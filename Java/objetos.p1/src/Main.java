public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Franco Tagliero", 27, "40444564");
        Persona p3 = new Persona("Marcos Conigliaro", 22, "45567432", 77.9, 182.4);

        System.out.println("Indice de masa corporal IMC: ");
        String peso;
        if ( p3.calcularIMC() < 0 ){
            peso = "Peso bajo";
        } else {
            if( p3.calcularIMC() < 1 ) {
                peso = "Peso saludable";
            }else {
                peso = "Sobre peso";
            }
        }
        System.out.println(peso);
        System.out.println("-------------");
        if(p3.esMayorDeEdad()) {
            System.out.println(p3.getNombre()+" es mayor de edad");
        }else {
            System.out.println(p3.getNombre()+" es menor de edad");
        }
        System.out.println(p3.toString());
    }
}
