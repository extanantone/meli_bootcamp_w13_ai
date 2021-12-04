package com.bootcamp.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDTO {

    private Long id;
    private String title;
    private String description;
    private Boolean status;
}
