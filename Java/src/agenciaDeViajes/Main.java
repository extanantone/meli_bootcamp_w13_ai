package agenciaDeViajes;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Nadia", "Verdier", "123455", "hola@mail.com");
        Localizador l1 = new Localizador(c1);

        Reserva r1 = new ReservaBoletos(100);
        Reserva r2 = new ReservaComida(30);
        Reserva r3 = new ReservaHoteles(250);
        Reserva r4 = new ReservaTransporte(84);

        l1.addReserva(r1);
        l1.addReserva(r2);
        l1.addReserva(r3);
        l1.addReserva(r4);

        Localizador l2 = new Localizador(c1);

        Reserva r5 = new ReservaHoteles(500);
        Reserva r6 = new ReservaHoteles(230);
        Reserva r7 = new ReservaBoletos(1300);
        Reserva r8 = new ReservaBoletos(2400);

        l2.addReserva(r5);
        l2.addReserva(r6);
        l2.addReserva(r7);
        l2.addReserva(r8);

        System.out.println(l1.toString());
        System.out.println("\n");
        System.out.println(l2.toString());
    }
}
