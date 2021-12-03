package bds.ormjpa.dtos;

import bds.ormjpa.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class StudentDTO {
    private String dni;
    private String name;
    private String lastname;

}
