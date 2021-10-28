package com.app.model;

import java.util.List;

public class Localizador{

    private boolean hotel;
    private String hotelName;
    private int numberHotelReserves;
    private boolean comida;
    private List<String> comidas;
    private boolean boletos;
    private int numberBoletos;
    private boolean transporte;
    private int discount = 0;
    private int price;
    private String aerolinea;

    public Localizador(boolean hotel, int numberHotelReserves, String hotelName ,boolean comida,List<String> comidas,boolean boletos,int numberBoletos,String aerolinea,boolean transporte,int price){
        this.transporte=transporte;
        this.hotel = hotel;
        this.hotelName = hotelName;
        this.comida=comida;
        this.boletos=boletos;
        this.comidas = comidas;
        this.discount = 0;
        this.price = price;
        this.aerolinea = aerolinea;
        this.numberBoletos=numberBoletos;
        this.numberHotelReserves = numberHotelReserves;
        if(isFullPackage()) discount=10;
        if(this.numberBoletos==2 || this.numberHotelReserves==2) discount+=5;
    }

    public boolean isBoletos() {
        return boletos;
    }

    public boolean isComida() {
        return comida;
    }

    public boolean isHotel() {
        return hotel;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public int getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }

    public void applyDiscount(int discount){
        this.discount+= discount;
    }

    private boolean isFullPackage(){
        return boletos && comida && hotel && transporte;
    }

    public int getNumberBoletos() {
        return numberBoletos;
    }

    public int getNumberHotelReserves() {
        return numberHotelReserves;
    }

    public double getPriceWithDiscount(){
        double percentage =(double) (100-discount)/100;
        return ((double)price)*percentage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public List<String> getComidas() {
        return comidas;
    }

    public String getAerolinea() {
        return aerolinea;
    }
    
}