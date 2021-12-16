package com.example.easynotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

}
