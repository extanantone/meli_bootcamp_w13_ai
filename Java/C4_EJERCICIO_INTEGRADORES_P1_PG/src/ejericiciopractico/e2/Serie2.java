package ejericiciopractico.e2;

public class Serie2<T extends Number> extends Series<T>{


    Number contador = 2;
    @Override
    public T valorSiguiente(){
        valorActual = valorActual.doubleValue() + contador.doubleValue();
        return (T) valorActual;
    }

}
