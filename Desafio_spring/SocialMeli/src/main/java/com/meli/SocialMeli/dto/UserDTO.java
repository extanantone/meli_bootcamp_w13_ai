package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO implements Serializable {
    private int userId;
    private String userName;
}
