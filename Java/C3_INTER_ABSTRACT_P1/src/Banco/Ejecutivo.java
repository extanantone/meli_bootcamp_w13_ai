package Banco;

public class Ejecutivo extends Cliente
{
    public Ejecutivo(String nombre)
    {
        super(nombre);
        depositoBehavior = new TransactionOk();
        transferenciaBehavior = new TransactionOk();
        retiroEfectivoBehavior = new NoTransactionOK();
        consulSaldoBehavior = new NoTransactionOK();
        pagoServBehavior = new NoTransactionOK();
    }
}
