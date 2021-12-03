package com.example.JPASpring.service;

import com.example.JPASpring.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final IStudentRepository stuRepo;

	public StudentService(IStudentRepository stuRepo) {
		this.stuRepo = stuRepo;
	}
}
