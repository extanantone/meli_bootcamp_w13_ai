package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {

	@Mock
	private IObtenerDiplomaService diplomaService;

	@InjectMocks
	private ObtenerDiplomaController diplomaController;

	@Test
	public void singularSubjectAverageScoreIsItsScoreTest() {
		String studentName = "Carlitos";
		Double singleScore = 8.0;
		SubjectDTO singularSubject = new SubjectDTO("Física", singleScore);
		singularSubject.setScore(singleScore);
		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(singularSubject);

		StudentDTO expectedStudent = new StudentDTO(1L, studentName,
			"El alumno " + studentName + " ha obtenido un promedio de 8.00. Puedes mejorar.",
				singleScore, subjects);

		when(diplomaService.analyzeScores(1L)).thenReturn(expectedStudent);

		StudentDTO result = diplomaController.analyzeScores(1L);

		assertEquals(result.getAverageScore(), singleScore);
	}

	@Test
	public void multipleSubjectsAverageScoreIsItsAverageTest() {
		String studentName = "Carlitos";
		Double firstScore = 9.0;
		Double secondScore = 6.0;
		Double thirdScore = 8.0;
		SubjectDTO firstSubject = new SubjectDTO("Física", firstScore);
		SubjectDTO secondSubject = new SubjectDTO("Química", secondScore);
		SubjectDTO thirdSubject = new SubjectDTO("Matemática", thirdScore);
		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(firstSubject);
		subjects.add(secondSubject);
		subjects.add(thirdSubject);
		Double expectedAvgScore = (firstScore + secondScore + thirdScore)/3;

		StudentDTO expectedStudent = new StudentDTO(1L, studentName,
				"El alumno " + studentName + " ha obtenido un promedio de 7.66. Puedes mejorar.",
				expectedAvgScore, subjects);

		when(diplomaService.analyzeScores(1L)).thenReturn(expectedStudent);

		StudentDTO result = diplomaController.analyzeScores(1L);

		assertEquals(result.getAverageScore(), expectedAvgScore);
	}
}