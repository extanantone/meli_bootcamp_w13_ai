package com.jpaexample.demo.repositorios;

import com.jpaexample.demo.modelos.Direccion;
import com.jpaexample.demo.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioDireccion extends JpaRepository<Direccion,Long> {


}
