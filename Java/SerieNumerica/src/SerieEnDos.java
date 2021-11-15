public class SerieEnDos extends Prototipo{
    @Override
    public void reiniciar() {
        this.setValorInicial(0);
    }

    @Override
    public Integer siguienteValor() {
        this.setValorInicial(this.getValorInicial()+2);
        return this.getValorInicial();
    }

}
