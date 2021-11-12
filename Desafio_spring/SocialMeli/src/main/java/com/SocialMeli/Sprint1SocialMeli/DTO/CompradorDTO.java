package com.SocialMeli.Sprint1SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompradorDTO {
    private int userID;
    private String user_name;
    private List<Integer> followeds;

}
