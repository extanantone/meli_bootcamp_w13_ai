package INTROJAVAP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    List<String> mensajeStrings = new LinkedList<>();

    int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
    double precioFijo = 1500;
    double patrullaje = 700;


    public void calcularMontoFactura() {
        //Tu codigo aqui
        for (int i = 0; i < 7; i++ ) {
            if (serviciosCli[i] == 1) {
                imprimirMensaje("El tipo de servicio es " + serviciosCli[i]);
                imprimirMensaje ("El monto de la factura es de: " + precioFijo);
            }
            else {
                imprimirMensaje("El tipo de servicio es 2");
                imprimirMensaje("El monto de la factura es de: " + (precioFijo + patrullaje));
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
