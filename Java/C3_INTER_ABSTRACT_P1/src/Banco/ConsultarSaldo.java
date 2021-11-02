package Banco;

public class ConsultarSaldo implements Transaccion
{
    @Override
    public boolean transaccionOK()
    {
        System.out.println("Saldo disponible: 1000");
        return true;
    }

    @Override
    public boolean transaccionNoOK()
    {
        System.out.println("Error al obtener el saldo");
        return true;
    }
}
