package com.example.link_tracker.Dto;


public class LinkDto {
    private String url,password;
    private boolean valido = true;
    int clicks = 0;

    public LinkDto() {
    }

    public LinkDto(String url, String password) {
        this.url = url;
        this.password = password;
    }
    public boolean isValido() {
        return valido;
    }

    public void invalidar() {
        this.valido = false;
    }
    public String getUrl() {
        return url;
    }

    public void addClick(){
        this.clicks++;
    }

    public int getClicks(){return this.clicks;}

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean validarPassword(String password){
        return this.password.equals(password);
    }
}
