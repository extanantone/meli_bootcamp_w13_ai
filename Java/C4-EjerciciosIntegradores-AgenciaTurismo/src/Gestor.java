import productos.Producto;
import productos.TipoProducto;

import java.util.ArrayList;

public class Gestor {

    public static ArrayList<Integer> productosTotal = new ArrayList<Integer>();

    public static Boolean esPaqueteCompleto(ArrayList<Producto> productos){

        ArrayList<Integer> productosTotalAux = productosTotal;

        int i = 0;

        while(productosTotalAux.size() > 0 && productos.size() < i){

            if(productosTotalAux.contains(productos.get(i).getTipoProducto()))
                productosTotalAux.remove(productos.get(i).getTipoProducto());

            i++;
        }

        if(productosTotalAux.size() == 0)
            return true;

        return false;
    }

    public static void calcularDescuento(ArrayList<Producto> productos){

    }

    public static double calcularTotalConDesc(Localizador localizadorActual){

        double descuentoTotal = 0;
        boolean esPaqueteCompleto;
        descuentoTotal += calcularDescuentoPorLocalizador(localizadorActual.getCliente());

        if(esPaqueteCompleto = esPaqueteCompleto(localizadorActual.getProductos()))
            descuentoTotal += 10;

        return descuentoTotal;
    }

    public static double calcularDescuentoPorLocalizador(Cliente cliente){

        final int LOCALIZADORES_2 = 2;
        final int DESCUENTO_5 = 5;

        int legajoCliente = cliente.getLegajo();
        int contadorLocalizadores = 0;

        for(Localizador l: Main.localizadores) {
           if(l.getCliente().getLegajo() == legajoCliente)
               contadorLocalizadores++;
        }

        if(contadorLocalizadores >= LOCALIZADORES_2) {
            return DESCUENTO_5;
        }

        return 0;
    }

}
