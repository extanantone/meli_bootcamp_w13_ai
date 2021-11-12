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
}
