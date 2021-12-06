package com.jpaexample.demo.repositorios;

import com.jpaexample.demo.modelos.one_to_many.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuarios,Long> {

    Usuarios findByDni(String dni);
}
