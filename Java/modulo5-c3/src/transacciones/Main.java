package transacciones;

public class Main {
    public static void main (String[] args) {
        Basic tomas = new Basic();
        System.out.println(tomas.consultarSaldo());
        tomas.pagarServicio("Luz");
        Cobrador natalia = new Cobrador();
        System.out.println(natalia.consultarSaldo());
        natalia.retirarEfectivo(42);
        Ejecutivo jorge = new Ejecutivo();
        jorge.depositar(23);
        jorge.transferir(10, natalia);
    }
}
