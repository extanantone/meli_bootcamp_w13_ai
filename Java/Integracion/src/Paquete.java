public class Paquete {
    private boolean hotel,comida,boletos,transporte,descuento;
    private double costoHotel,costoComida,costoBoletos,costoTransporte;

    public double getCostoHotel() {
        return costoHotel;
    }

    public void setCostoHotel(double costoHotel) {
        if (this.descuento)
        this.costoHotel = costoHotel;
    }

    public double getCostoComida() {
        return costoComida;
    }

    public void setCostoComida(double costoComida) {
        this.costoComida = costoComida;
    }

    public double getCostoBoletos() {
        return costoBoletos;
    }

    public void setCostoBoletos(double costoBoletos) {
        this.costoBoletos = costoBoletos;
    }

    public double getCostoTransporte() {
        return costoTransporte;
    }

    public void setCostoTransporte(double costoTransporte) {
        this.costoTransporte = costoTransporte;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isBoletos() {
        return boletos;
    }

    public void setBoletos(boolean boletos) {
        this.boletos = boletos;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public Paquete(boolean hotel, boolean comida, boolean boletos, boolean transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
        if(hotel && comida && boletos && transporte) descuento = true;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "hotel=" + hotel +
                ", comida=" + comida +
                ", boletos=" + boletos +
                ", transporte=" + transporte +
                '}';
    }


    public double getCostoTotal(){
        return this.costoBoletos + this.costoComida + this.costoHotel + this.costoTransporte;
    }

    public void aplicarDescuento(){
        if(this.descuento){
            this.costoTransporte = this.costoTransporte * 0.90;
            this.costoHotel = this.costoHotel * 0.90;
            this.costoBoletos = this.costoBoletos * 0.90;
            this.costoComida = this.costoComida * 0.90;
        }
    }
}
