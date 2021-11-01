public class Impresora implements Imprimible<Documento>{
    public Impresora() {
        System.out.println("Encendiendo impresora");
    }

    @Override
    public void imprimir(Documento obj){
        System.out.println(obj.toString());
    }
}
