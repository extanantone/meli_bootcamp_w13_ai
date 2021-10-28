package bootcamp;

public class SerieDe3 extends SerieProgresiva {
    private static final Integer SALTO = 3;

    public SerieDe3(Integer valorInicial) {
        super(valorInicial);
    }

    public SerieDe3() {
        super(0);
    }

    @Override
    public Integer getValorSiguiente() {
        super.valorActual = super.valorActual.intValue() + SALTO;
        return super.valorActual.intValue();
    }
}
