package com.app.printer;

public class Pagina {

    private int pages;

    public Pagina(int pages){
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Page{\npage:"+pages+"\n}";
    }
    
}
