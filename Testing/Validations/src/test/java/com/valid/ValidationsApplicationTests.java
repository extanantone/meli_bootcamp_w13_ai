package com.valid;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valid.dto.FinalNoteDto;
import com.valid.dto.StudentNotesDto;
import com.valid.dto.SubjectDto;
import com.valid.exceptions.StudentNotFoundException;
import com.valid.model.Student;
import com.valid.repository.IStudentRepository;
import com.valid.service.IStudentNotesService;
import com.valid.service.StudentNotesService;
import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ValidationsApplicationTests {

	@Autowired
	private IStudentNotesService iStudentNotesService;

	@Autowired
	private IStudentRepository iStudentRepository;

	@Mock
	private IStudentRepository iStudentRepository2;

	@InjectMocks
	private StudentNotesService iStudentNotesService2;

	@Test
	void shouldCalculateCorrectAverage() {
		StudentNotesDto dto = new StudentNotesDto("Juan", List.of(new SubjectDto("Calculo",10),new SubjectDto("Fisica",2)));
		FinalNoteDto fn =  iStudentNotesService.getAverageNote(dto);
		assertEquals(fn.getAverageScore(),6);
	}

	@Test
	void shouldSendErrorIFstudentNotExist(){
		StudentNotesDto dto = new StudentNotesDto("Jorge",null);
		assertThrows(StudentNotFoundException.class,()->iStudentNotesService.getAverageNote(dto));
	}

	@Test
	void shouldBeNotFindUnexistUser(){
		Optional<Student> user = iStudentRepository.findById(10);
		assertTrue(user.isEmpty());
	}
	@Test
	void shouldBeFindExistUser(){
		Optional<Student> st = iStudentRepository.findById(1);
		assertTrue(st.isPresent());
	}

	@Test
	void shoudntBeDeleteUnexistUser(){
		List<Student> users = iStudentRepository.findAll();
		users.remove(new Student(10,"test"));
		List<Student> users2 = iStudentRepository.findAll();
		assertEquals(users,users2);
	}

	@Test
	void shouldBeRemoveExistUser(){
		List<Student> users = iStudentRepository.findAll();
		iStudentRepository.delete(new Student(3,"Pablo"));
		List<Student> user2 = iStudentRepository.findAll();
		assertTrue(users.size()!=user2.size());
	}

	@Test
	void mockShouldBeFindStudent(){
		when(iStudentRepository2.findByName("Luis")).thenReturn(Optional.of(new Student(1,"Luis")));
		FinalNoteDto note = iStudentNotesService2.getAverageNote(new StudentNotesDto("Luis",List.of(new SubjectDto("Calculo",10))));
		assertEquals(note.getAverageScore(),10);

	}

	@Test
	void  mockShouldBeFailWithUnexistUser(){
		when(iStudentRepository2.findByName("Jorge")).thenReturn(Optional.empty());
		assertThrows(StudentNotFoundException.class,()-> iStudentNotesService2.getAverageNote(new StudentNotesDto("Jorge",List.of())));
	}

}
