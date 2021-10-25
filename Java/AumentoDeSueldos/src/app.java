public class app {

    public static class Main {

        final static int SUELDO_20000 = 20000;
        final static int SUELDO_45000 = 45000;
        final static double AUMENTO_20 = 1.2;
        final static double  AUMENTO_10 = 1.1;
        final static double AUMENTO_5 = 1.05;

        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 21000; // monto de ejemplo
        double sueldoConAumento;

        public void calcularSueldo() {

            // Tu codigo aqui
            if (sueldoBase <= SUELDO_20000) {
                sueldoConAumento = sueldoBase * AUMENTO_20;
            }
            else {
                if (sueldoBase > SUELDO_20000 && sueldoBase <= SUELDO_45000){
                    sueldoConAumento = sueldoBase * AUMENTO_10;
                }
                else {
                    sueldoConAumento = sueldoBase * AUMENTO_5;
                }
            }

            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }

        public static void main(String[] args) {
            new Main().calcularSueldo();
        }

    }
}
