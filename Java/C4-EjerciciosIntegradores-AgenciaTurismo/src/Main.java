import productos.*;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Localizador> localizadores = new ArrayList<Localizador>();

    public static void main(String[] args) {

        TipoProducto productoHotel = new TipoProducto(1,"Hotel");
        TipoProducto productoBoleto = new TipoProducto(2,"Boleto");
        TipoProducto productoTransporte = new TipoProducto(3,"Transporte");
        TipoProducto productoComida = new TipoProducto(4,"Comida");

        Producto productoH = new Hotel(1000,1,"Hotel");
        Producto productoB = new Boleto(900,2,"Boleto");
        Producto productoT = new Transporte(800,1,"Transporte");
        Producto productoC = new Comida(700,1,"Comida");

        Cliente cliente1 = new Cliente(1,12345678,"Juan","Perez");

        Localizador localizador1 = new Localizador(cliente1);
        Localizador localizador2 = new Localizador(cliente1);

        localizador1.agregarProducto(productoH);
        localizador1.agregarProducto(productoB);
        localizador1.agregarProducto(productoT);
        localizador1.agregarProducto(productoC);

        localizadores.add(localizador1);
        localizadores.add(localizador2);

        double valor = Gestor.calcularTotalConDesc(localizador1);

        System.out.println(valor);

    }
}
