import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan",23,"1233898705");
        Persona persona3 = new Persona("Juan",23,"1233898705",84.0, 1.72);

        System.out.println();
        System.out.println("Índice de masa corporal (IMC): " + String.valueOf(persona3.calcularIMC()));
        System.out.println("Es mayor de edad: " + String.valueOf(persona3.esMayorDeEdad()));
        System.out.println("Información completa de la persona:");
        System.out.println(persona3.toString());

        List<String> mensajeStrings = new LinkedList<>();

        int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        public void calcularMontoFactura() {
            //Tu codigo aqui
            for (int i=0;i<serviciosCli.length;i++ ) {
                if (serviciosCli[i] == 1) {
                    imprimirMensaje("El tipo de servicio es: " + String.valueOf(serviciosCli[i]));
                    imprimirMensaje ("El monto de la factura es de: " + String.valueOf(1500));
                }
                else {
                    imprimirMensaje("El tipo de servicio es: " + String.valueOf(serviciosCli[i]));
                    imprimirMensaje("El monto de la factura es de: " + String.valueOf(2200));
                }
            }
        }

        private void imprimirMensaje(String mensaje) {
            mensajeStrings.add(mensaje);
            System.out.println(mensaje);
        }

    }
}
