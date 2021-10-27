package ejericiciopractico.e2;

public class Serie3<T extends Number> extends Series<T>{

    Number contador = 3;
    @Override
    public T valorSiguiente(){
        valorActual = valorActual.doubleValue() + contador.doubleValue();
        return (T)valorActual;
    }
}
