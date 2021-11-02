package Banco;

public class Deposito implements Transaccion
{
    @Override
    public boolean transaccionOK()
    {
        System.out.println("Deposito realizado con exito");
        return true;
    }

    @Override
    public boolean transaccionNoOK()
    {
        System.out.println("Error al realizar el deposito");
        return true;
    }
}
