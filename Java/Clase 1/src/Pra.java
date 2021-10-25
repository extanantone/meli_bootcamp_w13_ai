public class Pra {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 46000; // monto de ejemplo
    double sueldoConAumento;

    public void calcularSueldo() {

        // Tu codigo aqui
        if (sueldoBase <= 20000) {
            sueldoConAumento = (sueldoBase / 100) * 20 + sueldoBase;
        } else {
            if (sueldoBase > 20000 && sueldoBase <= 45000) {
                sueldoConAumento = (sueldoBase / 100) * 10 + sueldoBase;
            } else {
                sueldoConAumento = (sueldoBase / 100) * 5 + sueldoBase;
            }
        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
    public static void main(String[] args) {
        new Pra().calcularSueldo();
    }

}
