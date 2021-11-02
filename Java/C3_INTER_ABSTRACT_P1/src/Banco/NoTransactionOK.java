package Banco;

public class NoTransactionOK implements Transaccion
{
    @Override
    public boolean transaccionOK()
    {
        System.out.println("La transaccion no se puede realizar");
        return false;
    }

    @Override
    public boolean transaccionNoOK()
    {
        return !transaccionOK();
    }
}
