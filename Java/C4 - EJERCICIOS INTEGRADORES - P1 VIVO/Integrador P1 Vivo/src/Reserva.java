public class Reserva {
    private int numeroHabitacion;
    private Double precio ;
    private String nombreHotel;
    private String fechaInicio;
    private String fechaFin;


    public Reserva(int numeroHabitacion, Double precio, String nombreHotel, String fechaInicio, String fechaFin) {
        this.numeroHabitacion = numeroHabitacion;
        this.precio = precio;
        this.nombreHotel = nombreHotel;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Numero de habitacion: "+this.numeroHabitacion +"\n"+
                "Precio: "+ this.precio +"\n"+
                "Nombre de hotel: "+ this.nombreHotel +"\n"+
                "Fecha de inicio: "+ this.fechaInicio +"\n"+
                "Fecha de fin: "+ this.fechaFin +"\n";
    }
}
