package com.MeLi.SocialMeli.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoSeguidosDTO {
    private int user_id;
    private String user_name;
    private List<VendedorDTO> followed;

}
