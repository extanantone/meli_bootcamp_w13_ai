package com.app.printer;

public class Informe implements Imprimible{

    private int longitud;
    private int cantidadPaginas;
    private String autor;
    private String supervisor;

    public Informe(int longitud,int cantidadPaginas, String autor,String supervisor){
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.supervisor = supervisor;
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
        
    }

    @Override
    public String toString() {
       return "Informe{\nlongitud:"+longitud+"\ncantidadPaginas:"+cantidadPaginas+
                "\nautor: "+autor+"\nsupervisor: "+supervisor+"\n}";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }
    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    
}
