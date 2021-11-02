package Banco;

public class TransactionOk implements Transaccion
{
    @Override
    public boolean transaccionOK()
    {
        System.out.println("Transaccion realizada con éxito");
        return true;
    }

    @Override
    public boolean transaccionNoOK()
    {
        return !transaccionOK();
    }
}
