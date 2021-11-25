package SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    int productId;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
