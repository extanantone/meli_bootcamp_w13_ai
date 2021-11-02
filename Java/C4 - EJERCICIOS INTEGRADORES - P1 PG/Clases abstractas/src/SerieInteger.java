public class SerieInteger extends Prototipo<Integer>{

    public SerieInteger(Integer valor_serie){
        this.valor_serie = valor_serie;
        this.valor_actual = 0;
        this.valor_inicial = 0;
    }

    public Integer siguiente(){
        this.valor_actual+= this.valor_serie;
        return this.valor_actual;
    }

    public void reiniciar(){
        this.valor_actual = this.valor_inicial;
    }

    public void valorInicial(Integer valor_inicial) {
        this.valor_inicial = valor_inicial;
    }
}
