package com.anfel024.marketplace.persistence.crud;

import com.anfel024.marketplace.persistence.entity.ProductosEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductoCrudRepository extends CrudRepository<ProductosEntity, Integer> {
    List<ProductosEntity> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<ProductosEntity>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
