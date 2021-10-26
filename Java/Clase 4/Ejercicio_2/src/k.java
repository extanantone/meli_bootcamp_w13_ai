class Perecedero extends Producto{

    int diasxcaducar;

    public Perecedero(){
    }

    public Perecedero(String nombre, double precio, int diasxcaducar) {
        super(nombre, precio);
        this.diasxcaducar = diasxcaducar;
    }

    public int getDiasxcaducar() {
        return diasxcaducar;
    }

    public void setDiasxcaducar(int diasxcaducar) {
        this.diasxcaducar = diasxcaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasxcaducar=" + diasxcaducar +
                '}';
    }

    @Override
    public double calcularValor(int cantidadDeProductos) {
        double valor = super.calcularValor(cantidadDeProductos);
        double descuento = 0;
        if(this.diasxcaducar == 1){
            descuento = valor/4;
        }else if(this.diasxcaducar == 2){
            descuento = valor/3;
        }else if(this.diasxcaducar == 3){
            descuento = valor/2;
        }
        return descuento;
    }
}