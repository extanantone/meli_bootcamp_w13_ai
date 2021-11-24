package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class FactoryStudents {

    public StudentDTO getValidStudent(){
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matemática",9.0));
        subjects.add(new SubjectDTO("Física",7.0));
        subjects.add(new SubjectDTO("Química",6.0));


        StudentDTO student = new StudentDTO(1L,"Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,subjects);
        return student;
    }

    public StudentDTO getEmptyStudent(){
        return new StudentDTO();
    }

    public StudentDTO getStudentWithInvalidName(){
        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(new SubjectDTO("Matemática",9.0));
        subjects.add(new SubjectDTO("Física",7.0));
        subjects.add(new SubjectDTO("Química",6.0));


        StudentDTO student = new StudentDTO(1L,"Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,subjects);
        return student;
    }

}
