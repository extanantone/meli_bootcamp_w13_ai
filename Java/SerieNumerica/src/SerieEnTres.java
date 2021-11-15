public class SerieEnTres extends Prototipo{

    @Override
    public void reiniciar() {
        this.setValorInicial(0);
    }

    @Override
    public Integer siguienteValor() {
        this.setValorInicial(this.getValorInicial()+3);
        return this.getValorInicial();
    }
}
