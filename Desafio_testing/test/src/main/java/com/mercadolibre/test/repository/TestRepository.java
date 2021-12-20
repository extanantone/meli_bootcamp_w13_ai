package com.mercadolibre.test.repository;

import com.mercadolibre.test.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
