package JAVA.C4.P1.EJ2.Model;

public class ReservaHotel extends Reserva {
    private boolean habitacionComun;

    public ReservaHotel(int codigo, String nombreEmpresa, int cantidad, boolean habitacionComun) {
        super(codigo, nombreEmpresa, 300, cantidad);
        this.habitacionComun = habitacionComun;
    }

    public boolean isHabitacionComun() {
        return habitacionComun;
    }

    public void setHabitacionComun(boolean habitacionComun) {
        this.habitacionComun = habitacionComun;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "habitacionComun=" + habitacionComun +
                '}';
    }
}
