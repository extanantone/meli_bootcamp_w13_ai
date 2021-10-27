package com.app.printer;

import java.util.List;

public class Libro implements Imprimible {

    private List<Pagina> paginas;

    public Libro(List<Pagina> paginas){
        this.paginas = paginas;
    }

    @Override
    public void imprimir() {
        
        
    }
    
}
