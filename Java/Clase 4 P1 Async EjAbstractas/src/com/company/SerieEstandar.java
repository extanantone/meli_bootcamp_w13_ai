package com.company;

public abstract class SerieEstandar<T extends Number> {
    protected T valorInicial;
    protected Double valor;
    protected Double salto;

    public Double devolverSiguienteValor() {
        valor += salto;
        return valor;
    }

    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
        this.valor = valorInicial.doubleValue();
    }

    public void reiniciarSerie(){
        valor = valorInicial.doubleValue();
    }

}
