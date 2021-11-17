package POOP2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto producto1 = new Perecedero("Pan",1,10);
        Producto producto2 = new Perecedero("Queso",2, 20);
        Producto producto3 = new Perecedero("Jamon", 3, 30);
        Producto producto4 = new Perecedero("Tomate", 4, 40);
        Producto producto5 = new Perecedero("Hamburguesa", 5, 50);

        Producto producto6 = new NoPerecedero("Leche",10, "Frio");
        Producto producto7 = new NoPerecedero("Fideos", 20, "Seco");
        Producto producto8 = new NoPerecedero("Tortilla", 30, "Sin TACC");
        Producto producto9 = new NoPerecedero("Arroz", 40, "Seco");
        Producto producto10 = new NoPerecedero("Ravioles", 50, "Pasta");




    }
}
