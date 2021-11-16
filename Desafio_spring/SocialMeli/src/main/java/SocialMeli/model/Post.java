package SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Post {
    int user_id;
    int id_post;
    LocalDate date;
    Product detail;
    int category;
    double price;

    //Promo Bonus
    boolean has_promo;
    double discount;

    //NnPromoConstructor
    public Post(int user_id, int id_post, LocalDate date, Product detail, int category, double price) {
        this.user_id = user_id;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
