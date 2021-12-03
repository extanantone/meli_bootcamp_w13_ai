package bds.ormjpa.repositories;

import bds.ormjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends
        JpaRepository<Student, Long> {
}
