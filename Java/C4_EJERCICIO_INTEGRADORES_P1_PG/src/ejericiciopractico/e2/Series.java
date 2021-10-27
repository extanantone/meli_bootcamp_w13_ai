package ejericiciopractico.e2;

public abstract class Series<T extends Number> {

    protected Number valorActual = null;
    protected Number valorInicial = null;

    public abstract Number valorSiguiente();

    public void reiniciarSerie(){
        if(valorInicial==null)
            System.out.println("Por favor indique un valor inicial par ala serie");
        else
            valorActual = valorInicial;
    }

    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
        if(valorActual==null)
            valorActual = valorInicial;
    }


}
