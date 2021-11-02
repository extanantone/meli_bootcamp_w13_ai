package Banco;

public class Basic extends Cliente
{
    public Basic(String nombre)
    {
        super(nombre);
        depositoBehavior = new NoTransactionOK();
        transferenciaBehavior = new NoTransactionOK();
        retiroEfectivoBehavior = new TransactionOk();
        consulSaldoBehavior = new TransactionOk();
        pagoServBehavior = new TransactionOk();
    }
}
