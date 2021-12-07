package com.example.easynotes.dto;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThankDTO {
    @JsonProperty("note_id")
    Long noteId;
    UserResponseDTO user;
    private Date createdAt;

}