package com.example.SocialMeli.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO {
    private Long idVendedor;
    private List<PostDTO> posts;
}
