package com.socialmeli.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguidoresDTO {
    private int user_id;
    private String user_name;
    private List<CompradoresDTO> followers;
}
