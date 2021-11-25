package com.MeLi.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PubVendedoresDTO {
    private int user_id;
    private List<VendedorDTO> posts;
}
