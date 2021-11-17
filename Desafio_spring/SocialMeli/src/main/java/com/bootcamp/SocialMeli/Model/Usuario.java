package com.bootcamp.SocialMeli.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Usuario {

    private Integer userId;
    private String userName;

    public Usuario(Integer userId, String userName) {
    }

    private static Integer con_id=0;
    public Usuario(){
        userId =++con_id;
    }

    public Usuario(String userName){
        this();
        this.userName = userName;
    }
}
