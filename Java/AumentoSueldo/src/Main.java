public class Main {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoConAumento;

    final double SUELDO_20000 = 20000.0;
    final double SUELDO_45000 = 45000.0;

    final double AUMENTO_20_PORC = 1.20;
    final double AUMENTO_10_PORC = 1.1;
    final double AUMENTO_5_PORC = 1.05;

    public void calcularAumento() {

        // Tu codigo aqui
        if (sueldoBase<=SUELDO_20000) {
            sueldoConAumento = sueldoBase*AUMENTO_20_PORC;
        }
        else {
            if (sueldoBase>SUELDO_20000 && sueldoBase<=SUELDO_45000){
                sueldoConAumento = sueldoBase*AUMENTO_10_PORC;
            }
            else {
                sueldoConAumento = sueldoBase*AUMENTO_5_PORC;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new Main().calcularAumento();
    }

}