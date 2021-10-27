package com.company;

public abstract class Cliente {
    int idCliente;

    abstract void realizarOperacion(Transaccion transaccion);
}
