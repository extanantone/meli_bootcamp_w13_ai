package bootcamp;

public class Informe implements Imprimible{
    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir(){
        System.out.println("---- INFORME ----");
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("Cantidad de paginas: " + this.cantPaginas);
        System.out.println(this.texto);
    }
}
