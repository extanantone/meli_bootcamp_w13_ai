import Banco.*;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        Cliente cobrador = new Cobrador("Juanito");
        Cliente ejecutivo = new Ejecutivo("Perez");
        Cliente basic= new Basic("Gomez");
        cobrador.performDeposit();
        cobrador.performRetiro();
        ejecutivo.performSaldo();
        ejecutivo.performTransferencia();
        basic.performPago();

    }
}
