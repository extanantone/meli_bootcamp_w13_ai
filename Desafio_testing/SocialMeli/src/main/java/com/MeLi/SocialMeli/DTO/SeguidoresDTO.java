package com.MeLi.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguidoresDTO {
    @NotNull
    @Min(1)
    private int user_id;
    private String user_name;
    private int followers_count;
}
