package bds.ormjpa.repositories;

import bds.ormjpa.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class ImplStudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Long addStudent(Student student){
        entityManager.persist(student);
        return student.getId();
    }
}
