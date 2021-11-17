package com.socialmeli.demo.dto;

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
public class VendedoresDTO {
    private int user_id;
    private String user_name;
    private List<PublicacionDTO> posts;

    public VendedoresDTO(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.posts = new ArrayList<>();
    }
}
