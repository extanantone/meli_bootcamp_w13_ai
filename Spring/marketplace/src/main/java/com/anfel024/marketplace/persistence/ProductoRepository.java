package com.anfel024.marketplace.persistence;

import com.anfel024.marketplace.persistence.crud.IProductoCrudRepository;
import com.anfel024.marketplace.persistence.entity.ProductosEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private IProductoCrudRepository iProductoCrudRepository;

    public List<ProductosEntity> getAll(){ return (List<ProductosEntity>) iProductoCrudRepository.findAll(); }

    public List<ProductosEntity> getByCategoria(int idCategoria){
        return (List<ProductosEntity>) iProductoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<ProductosEntity>> getEscasos(int cantidad){
        return iProductoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<ProductosEntity> getProducto(int idProducto){ return iProductoCrudRepository.findById(idProducto); }

    public ProductosEntity save(ProductosEntity productosEntity){ return iProductoCrudRepository.save(productosEntity); }

    public void delete(int idProducto){ iProductoCrudRepository.deleteById(idProducto); }
}
