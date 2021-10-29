package JAVA.C4.P1.EJ1;

import java.util.function.DoubleUnaryOperator;

public abstract class Prototipo<T extends Number> {
    private Number obj;
    private Number objValorInicial;

    public double valorSiguiente(T obj) {
        double calcular;
        if (this.obj == objValorInicial) {
            calcular = this.obj.doubleValue();
        } else {
            calcular = this.obj.doubleValue() + obj.doubleValue();
            this.obj = calcular;
        }
        return calcular;
    }


    public Number getObjValorInicial() {
        return objValorInicial;
    }

    public void setObjValorInicial(T objValorInicial) {
        this.objValorInicial = objValorInicial;
    }

    public void reiniciarSerie() {
        this.obj = this.objValorInicial;
    }

    public void valorInicial(T objValorInicial) {
        this.objValorInicial = objValorInicial;
        this.obj = objValorInicial;
    }

}
