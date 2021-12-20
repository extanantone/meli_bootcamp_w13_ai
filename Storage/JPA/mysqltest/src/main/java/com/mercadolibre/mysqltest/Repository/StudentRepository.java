package com.mercadolibre.mysqltest.Repository;

import com.mercadolibre.mysqltest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
