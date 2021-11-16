package com.example.socialmeli.demo.mapper;

import com.example.socialmeli.demo.dto.controllerToService.DTOProduct;
import com.example.socialmeli.demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

public static Product convertDTOProductToProduct(DTOProduct p){

    Product prod = new Product();
    prod.setProductId(p.getProductId());
    prod.setType(p.getType());
    prod.setProductName(p.getProductName());
    prod.setNotes(p.getNotes());
    prod.setColor(p.getColor());
    prod.setBrand(p.getBrand());

    return prod;
}

public static DTOProduct convertProductTODTOProduct(Product p){

    DTOProduct prod = new DTOProduct();
    prod.setProductId(p.getProductId());
    prod.setType(p.getType());
    prod.setProductName(p.getProductName());
    prod.setNotes(p.getNotes());
    prod.setColor(p.getColor());
    prod.setBrand(p.getBrand());

    return prod;

}


}
