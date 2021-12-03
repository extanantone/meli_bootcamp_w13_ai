package bds.ormjpa.model;

import bds.ormjpa.dtos.StudentDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private Integer parcial1;
    private Integer parcial2;
    private Integer integrador;

    public Student(StudentDTO studentDTO){
        dni = studentDTO.getDni();
        name = studentDTO.getName();
        lastname = studentDTO.getLastname();
    }

}
