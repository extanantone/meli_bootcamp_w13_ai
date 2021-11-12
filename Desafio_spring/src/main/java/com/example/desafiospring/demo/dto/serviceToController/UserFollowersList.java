package com.example.desafiospring.demo.dto.serviceToController;

import com.example.desafiospring.demo.model.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendorFollowersList {

    private int user_id;
    private String user_name;
    private List<Usuarios> followers;

}
