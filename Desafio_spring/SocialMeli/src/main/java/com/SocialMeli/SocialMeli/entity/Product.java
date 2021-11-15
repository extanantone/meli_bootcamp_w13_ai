package com.SocialMeli.SocialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product {
    protected int id;
    protected String name;
    protected String type;
    protected String brand;
    protected String color;
    protected String notes;
}
