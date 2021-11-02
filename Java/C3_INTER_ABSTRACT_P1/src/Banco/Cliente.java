package Banco;

public abstract class Cliente
{
    Transaccion depositoBehavior;
    Transaccion transferenciaBehavior;
    Transaccion retiroEfectivoBehavior;
    Transaccion consulSaldoBehavior;
    Transaccion pagoServBehavior;

    public void performDeposit()
    {
        depositoBehavior.transaccionOK();
    }

    public void performTransferencia()
    {
        transferenciaBehavior.transaccionOK();
    }

    public void performRetiro()
    {
        retiroEfectivoBehavior.transaccionOK();
    }

    public void performSaldo()
    {
        consulSaldoBehavior.transaccionOK();
    }

    public void performPago()
    {
        pagoServBehavior.transaccionOK();
    }

    public Cliente(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    private String nombre;
}
