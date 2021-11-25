package com.MeLi.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguimientoDTO {
    private int user_id_follower;
    private String user_name_follower;
    private int user_id_follow;
    private String user_name_follow;
    private String msj;

}
