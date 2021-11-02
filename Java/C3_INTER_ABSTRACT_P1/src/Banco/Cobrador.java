package Banco;

public class Cobrador extends Cliente
{
    public Cobrador(String nombre)
    {
        super(nombre);
        depositoBehavior = new NoTransactionOK();
        transferenciaBehavior = new NoTransactionOK();
        retiroEfectivoBehavior = new TransactionOk();
        consulSaldoBehavior = new TransactionOk();
        pagoServBehavior = new NoTransactionOK();
    }
}
