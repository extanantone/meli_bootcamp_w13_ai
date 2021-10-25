import java.util.LinkedList;
import java.util.List;

public class App {

    final static int SERVICIO_FIJO = 1;
    final static double PRECIO_SERVICIO_FIJO = 1500;
    final static double PRECIO_SERVICIO_PATRULLAJE = 2200;

    public static class Main {

        List<String> mensajeStrings = new LinkedList<>();

        int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        public void calcularMontoFactura() {
            //Tu codigo aqui
            for (int  c  : serviciosCli )
                if (c == SERVICIO_FIJO) {
                    imprimirMensaje("El tipo de servicio es: " + c);
                    imprimirMensaje("El monto de la factura es de: " + PRECIO_SERVICIO_FIJO);
                } else {
                    imprimirMensaje("El tipo de servicio es: " + c);
                    imprimirMensaje("El monto de la factura es de: " + PRECIO_SERVICIO_PATRULLAJE);
                }
        }

        private void imprimirMensaje(String mensaje) {
            mensajeStrings.add(mensaje);
            System.out.println(mensaje);
        }

        public static void main(String[] args) {
            new Main().calcularMontoFactura();
        }

    }
}
