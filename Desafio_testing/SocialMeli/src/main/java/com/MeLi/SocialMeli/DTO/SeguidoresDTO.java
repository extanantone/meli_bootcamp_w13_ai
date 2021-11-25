package com.MeLi.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguidoresDTO {
    private int user_id;
    private String user_name;
    private int followers_count;
}
