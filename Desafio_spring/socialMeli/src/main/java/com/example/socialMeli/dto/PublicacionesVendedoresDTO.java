package com.example.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicacionesVendedoresDTO {
    private int user_id;
    private List<PublicacionDTO> posts;

    public PublicacionesVendedoresDTO(int user_id) {
        this.user_id = user_id;
        this.posts = new ArrayList<>();
    }
}
