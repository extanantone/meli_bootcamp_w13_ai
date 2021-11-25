package SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Post {
    int userId;
    int idPost;
    LocalDate date;
    Product detail;
    int category;
    double price;

    //Promo Bonus
    boolean hasPromo;
    double discount;

}
