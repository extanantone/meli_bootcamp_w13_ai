package com.desafiospring.demo.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSellerFollowersCountDTO {

    //Definimos nuestro DTO
    private int userId;
    private String name;
    private int followers_count;

}
