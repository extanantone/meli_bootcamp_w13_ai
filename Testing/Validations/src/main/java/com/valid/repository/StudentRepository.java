package com.valid.repository;

import com.valid.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository implements IStudentRepository{

    private List<Student> students;
    public StudentRepository(){
        students = new ArrayList<>();
        students.add(new Student(1,"Juan"));
        students.add(new Student(2,"Luis"));
        students.add(new Student(3,"Pablo"));
    }

    @Override
    public Optional<Student> findByName(String name) {
        return students.stream().filter(u->u.getName().equals(name)).findFirst();
    }

    @Override
    public List<Student> findAll() {
        return students.stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Student> findById(int id) {
        return students.stream().filter(s->s.getId()==id).findFirst();
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }
}
