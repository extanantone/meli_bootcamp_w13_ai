package poo3;

public class Distribuidora {

    public static void main(String[] args) {
        Producto p[] = new Producto[5];

        p[0] = new Perecedero("Leche", 10, 10);
        p[1] = new Perecedero("Queso", 20, 3);
        p[2] = new Perecedero("Manteca", 5, 1);

        p[3] = new NoPerecedero("Fideos", 8, "Secos");
        p[4] = new NoPerecedero("Choclo", 15, "enlatados");

        double precioAcum = 0;

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getNombre() + " --Precio: " + p[i].calcular(5));
            precioAcum = precioAcum + p[i].calcular(5);
        }
        System.out.println("\nImporte acumulado: " + precioAcum);
    }

}
