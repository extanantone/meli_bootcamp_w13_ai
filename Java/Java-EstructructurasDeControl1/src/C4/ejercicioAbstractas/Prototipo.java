package C4.ejercicioAbstractas;

public abstract class Prototipo {

    private int valorSerie = 0;
    private int valorInicial = 0;

    public Prototipo(int valorSerie) {
        this.valorSerie = valorSerie;
    }

    public int getValorSiguiente(){
        this.valorInicial += valorSerie;
        return valorInicial;
    }

    public void setValorInicial(int valorInicial){
        this.valorInicial = valorInicial;
    }
}
