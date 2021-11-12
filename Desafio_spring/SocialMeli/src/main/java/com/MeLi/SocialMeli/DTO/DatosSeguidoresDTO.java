package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Comprador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatosSeguidoresDTO {
    private int id;
    private String user_name;
    private List<CompradorDTO> followers;
}
