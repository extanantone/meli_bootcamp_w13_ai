package com.SocialMeli.Sprint1SocialMeli.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguidosDTO {
    private Integer user_id;
    private String user_name;
    private List followed;
}
