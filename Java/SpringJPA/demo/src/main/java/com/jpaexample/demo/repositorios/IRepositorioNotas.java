package com.jpaexample.demo.repositorios;

import com.jpaexample.demo.modelos.one_to_many.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioNotas extends JpaRepository<Notas,Long> {

}
