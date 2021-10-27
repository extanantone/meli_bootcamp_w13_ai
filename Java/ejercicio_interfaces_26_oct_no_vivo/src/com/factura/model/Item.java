package com.factura.model;

public class Item {

    private String name;
    private int price;
    private int number;

    public Item(String name, int price,int number){
        this.name =name;
        this.price=price;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
    
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\nItem{\nname:"+name+",\nnumber:"+number+",\nprice:"+price+"\n}";
    }
    
}
