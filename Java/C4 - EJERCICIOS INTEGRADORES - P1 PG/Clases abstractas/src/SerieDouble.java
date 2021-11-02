public class SerieDouble extends Prototipo<Double>{

    public SerieDouble(Double valor_serie) {
        this.valor_serie = valor_serie;
        this.valor_actual = 0.0;
        this.valor_inicial = 0.0;
    }

    public Double siguiente(){
        this.valor_actual+= this.valor_serie;
        return this.valor_actual;
    }

    public void reiniciar(){
        this.valor_actual = this.valor_inicial;
    }

    public void valorInicial(Double valor_inicial) {
        this.valor_inicial = valor_inicial;
    }
}
