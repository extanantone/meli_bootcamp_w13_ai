package com.example.springii_2.dto;

import com.example.springii_2.models.Person;
import com.example.springii_2.models.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportPersonDTO implements Serializable {

    private String fullName;
    private String nameSport;




}
