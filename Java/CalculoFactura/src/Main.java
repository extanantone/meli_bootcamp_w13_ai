import java.util.LinkedList;
import java.util.List;

public class Main {

    List<String> mensajeStrings = new LinkedList<>();

    int serviciosCli [] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
    double totalFactura;


    final int SEGURIDAD_PRECIO_FIJO = 1500;
    final int SEGURIDAD_PATRULLAJE_PRECIO_FIJO = 2200;

    public void calcularMontoFactura() {
        //Tu codigo aqui
        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura=SEGURIDAD_PRECIO_FIJO;
                imprimirMensaje ("El monto de la factura es de: " + totalFactura);
            }
            else {
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura=SEGURIDAD_PATRULLAJE_PRECIO_FIJO;
                imprimirMensaje("El monto de la factura es de: " + totalFactura);
            }
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