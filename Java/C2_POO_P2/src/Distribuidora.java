import java.util.concurrent.ThreadLocalRandom;
public class Distribuidora
{
    public static void main(String[] args)
    {
        int cantidad = 0;

        Perecedero leche = new Perecedero("Leche", 23000, 2);
        Perecedero pollo = new Perecedero("Pollo", 13000, 1);
        Perecedero huevos = new Perecedero("Huevos", 10000, 1);
        Perecedero carne = new Perecedero("Carne", 19000, 2);
        Perecedero arroz = new Perecedero("Arroz", 10000, 2);
        NoPerecedero p6= new NoPerecedero("arvejas",800, "enlatado");
        NoPerecedero p7= new NoPerecedero("lentejas",2000, "empaquetado");
        NoPerecedero p8= new NoPerecedero("frijoles",2500, "empaquetado");
        NoPerecedero p9= new NoPerecedero("aceite",5000, "empaquetado");
        NoPerecedero p10= new NoPerecedero("salchicha",3000, "enlatado");

        Producto[] productos = new Producto[]{leche, pollo, huevos, carne, arroz, p6, p7, p8, p9, p10};

        for (Producto producto: productos)
        {
            cantidad = ThreadLocalRandom.current().nextInt(1, 6);
            System.out.printf("Precio final de %d productos de %s es: %.2f\n",
                    cantidad, producto.getNombre(), producto.calcular(cantidad));
        }
    }
}
