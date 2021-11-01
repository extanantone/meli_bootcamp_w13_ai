public class Main {
    public static void main(String[] args){
        System.out.println("Hello");

        String[] skills = {"Cocinar", "Reparar coches"};
        Curriculum curriculum = new Curriculum("Pedro Perez", skills);

        LibroPDF libroPDF = new LibroPDF(5,"Paolo Coelho", "Subrayas obscuras", "Ficción");
        Informe informe = new Informe(100, "Christina Arango", "Sonia Rodriguez", "Este texto debe ser muy muy muy muy muy pero muy muy muy largo.");


        Impresora impresora = new Impresora();
        impresora.imprimir(curriculum);
        impresora.imprimir(libroPDF);
        impresora.imprimir(informe);
    }
}
