package bootcamp;

public class SerieDe2 extends SerieProgresiva{
    private static final Integer SALTO = 2;

    public SerieDe2(Integer valorInicial) {
        super(valorInicial);
    }

    public SerieDe2() {
        super(0);
    }

    @Override
    public Integer getValorSiguiente() {
        super.valorActual = super.valorActual.intValue() + SALTO;
        return super.valorActual.intValue();
    }
}
