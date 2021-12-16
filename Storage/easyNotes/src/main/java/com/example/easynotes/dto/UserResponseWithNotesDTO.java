package com.example.easynotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseWithNotesDTO extends UserRequestDTO {

        @JsonProperty("author_notes")
        private Set<NoteResponseDTO> authorNotes;
}
