import java.util.List;

public class Main {


    public static void main(String[] args) {
        Prenda camisa = new Prenda("Adidas","2019");
        Prenda chaqueta = new Prenda("Nike", "2021");

        Guardaropa guardaRopa = new Guardaropa();
        Integer ticket = guardaRopa.guardarPrendas(List.of(camisa, chaqueta));

        System.out.println("---Guardarropa---");
        guardaRopa.mostrarPrendas();

        System.out.println("----Sacando ropa de casillero----");
        List<Prenda> prendas = guardaRopa.devolverPrendas(ticket);
        System.out.println("Prendas recibidas");
        prendas.stream().forEach(System.out::println);

        System.out.println("---Guardarropa---");
        guardaRopa.mostrarPrendas();
    }



}
