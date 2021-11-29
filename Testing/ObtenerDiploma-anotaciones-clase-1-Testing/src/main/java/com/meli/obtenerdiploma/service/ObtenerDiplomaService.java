package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Override
    public StudentDTO notas(StudentDTO peticion) {
        peticion.setAverageScore(calculateAverage(peticion.getSubjects()));
        peticion.setMessage(getGreetingMessage(peticion.getStudentName(), peticion.getAverageScore()));

        return peticion;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno con nombre" + studentName + " ha obtenido una nota promedio de: " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
