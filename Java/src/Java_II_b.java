import java.util.ArrayList;

public class Java_II_b {
    static void practicaExcepciones(){
        int a = 0;
        int b = 300;
        try{
            if (a == 0) {
                throw new IllegalArgumentException();
            }
            int cociente = b/a;
        } catch (Exception e){
            if(e.getClass() == (new IllegalArgumentException().getClass())){System.out.println("No se puede dividir por 0");}
          else{System.out.println("Se ha producido un error");}
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    static public class Producto{
        protected String nombre;
        protected double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Producto{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    '}';
        }

        public double calcular(int cantidadDeProductos){
            return  precio * cantidadDeProductos;
        }

    }

    static public class Perecedero extends Producto{
        private int diasPorCaducar;

        public Perecedero(String nombre, double precio, int diasPorCaducar) {
            super(nombre, precio);
            this.diasPorCaducar = diasPorCaducar;
        }

        public int getDiasPorCaducar() {
            return diasPorCaducar;
        }

        public void setDiasPorCaducar(int diasPorCaducar) {
            this.diasPorCaducar = diasPorCaducar;
        }

        @Override
        public String toString() {
            return "Perecedero{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", diasPorCaducar=" + diasPorCaducar +
                    '}';
        }

        @Override
        public double calcular(int cantidadDeProductos){
            double precioFinal = super.calcular(cantidadDeProductos);
            switch(diasPorCaducar){
                case 1:
                    precioFinal = precioFinal / 4.00;
                    break;
                case 2:
                    precioFinal = precioFinal / 3.00;
                    break;
                case 3:
                    precioFinal = precioFinal / 2.00;
                    break;
                default:
                    break;
            }
            return precioFinal;
        }

    }

    public static class NoPerecedero extends Producto{
        String tipo;

        public NoPerecedero(String nombre, double precio, String tipo) {
            super(nombre, precio);
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "NoPerecedero{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", tipo='" + tipo + '\'' +
                    '}';
        }
    }

    public static class Distribuidora{
        public static void main(String[] args) {
            ArrayList<Producto> listaProductos = new ArrayList<Producto>();
            listaProductos.add(new NoPerecedero("Pepsi", 200, "gaseosa"));
            listaProductos.add(new Perecedero("Pan", 100, 3));
            listaProductos.add(new NoPerecedero("Arroz", 70, "integral"));
            listaProductos.add(new Perecedero("Huevos", 300, 2));
            listaProductos.add(new NoPerecedero("Fideos", 80, "tirabuzon"));
            double precioTotal = 0.00;
            for(Producto p : listaProductos){
                precioTotal += p.calcular(5);
                System.out.print(p.toString());
                System.out.println(" Precio por 5: " + p.calcular(5));
            }
            System.out.println("Precio total: " + precioTotal);
        }
    }
}
