public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente((long)123123,"Santiago", "Acevedo");
        Paquete p1 = new Paquete(true,true,true,true);
        Paquete p2 = new Paquete(true,false,true,false);

        p1.setCostoTransporte(25);
        p1.setCostoBoletos(25);
        p1.setCostoComida(25);
        p1.setCostoHotel(10);
        p1.aplicarDescuento();

        Localizadores l1 = new Localizadores();
        l1.setListaPaquetes(p1);

        l1.aplicarDescuento();
        c1.setLista(l1);
        c1.aplicarDescuento();

        mostrar(c1);

        Localizadores l2 = new Localizadores();
        p2.setCostoTransporte(0);
        p2.setCostoBoletos(25);
        p2.setCostoComida(0);
        p2.setCostoHotel(10);
        p2.aplicarDescuento();
        l2.setListaPaquetes(p2);
        l2.setListaPaquetes(p2);
        l2.aplicarDescuento();
        c1.setLista(l2);
        c1.aplicarDescuento();
        mostrar(c1);

        Localizadores l3 = new Localizadores();

        l3.setListaPaquetes(p1);
        l3.aplicarDescuento();
        c1.aplicarDescuento();
        mostrar(c1);
    }

    public static void mostrar(Cliente c1) {
        System.out.println("El cliente: " + c1.getDni() + " reservo: ");
        c1.getLista().get((c1.getLista().size())-1).getListaPaquetes().forEach(p->System.out.println(p.toString()));
        System.out.println("Con un costo de: " + c1.getLista().get((c1.getLista().size())-1).getCosto() + '\n');
    }


}
