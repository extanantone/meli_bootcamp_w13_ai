package com.ejercicio.studentJPA.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "Estudiante")
@NoArgsConstructor
public class Student
{
    @Id
    private Long id;
    private String dni;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Double parcial1;
    private Double parcial2;
    private Double integrador;

    public Student(Long id, String dni, String name, String lastName)
    {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }
}