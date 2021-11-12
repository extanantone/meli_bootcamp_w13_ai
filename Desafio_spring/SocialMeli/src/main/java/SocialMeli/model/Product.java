package SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Product {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
