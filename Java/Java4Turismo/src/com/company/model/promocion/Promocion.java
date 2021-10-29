package com.company.model.promocion;

public abstract class Promocion {
    double porcentaje;

    public Promocion(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getDescuento() {
        if( cumpleCondicion() ) {
            return porcentaje;
        }
        return 0;
    }

    protected abstract boolean cumpleCondicion();

}
