package com.app.printer;

import java.util.List;
import java.util.jar.Pack200;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Libro implements Imprimible {

    private List<Pagina> paginas;

    public Libro(List<Pagina> paginas){
        this.paginas = paginas;
    }

    @Override
    public void imprimir() {
        List<Pagina> p= paginas.stream().sorted((x,y)->x.getPages()<y.getPages()?-1:1).collect(Collectors.toList());
        
    }

    @Override
    public String toString() {
        return "Libro{\npaginas:"+paginas.toString()+"\n}";
    }
    
}
