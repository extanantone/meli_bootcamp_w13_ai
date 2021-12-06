package com.example.easynotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
// Used when extends from other DTO
// link: https://stackoverflow.com/questions/38572566/warning-equals-hashcode-on-data-annotation-lombok-with-inheritance
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponseDTO extends NoteDTO {

    private Long id;

}
