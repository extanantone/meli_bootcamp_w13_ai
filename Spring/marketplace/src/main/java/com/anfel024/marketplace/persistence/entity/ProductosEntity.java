package com.anfel024.marketplace.persistence.entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "productos", schema = "public", catalog = "platzi_spring")
public class ProductosEntity {
    private Integer idProducto;
    private Integer idCategoria;
    private String nombre;
    private String codigoBarras;
    private BigDecimal precioVenta;
    private Integer cantidadStock;
    private Boolean estado;
    private CategoriasEntity categoriasEntity;

    @ManyToOne
    @JoinColumn(name= "id_categoria", insertable = false, updatable = false)
    public CategoriasEntity getCategoriasEntity() {
        return categoriasEntity;
    }

    public void setCategoriasEntity(CategoriasEntity categoriasEntity) {
        this.categoriasEntity = categoriasEntity;
    }

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Column(name= "id_categoria")
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "codigo_barras")
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Basic
    @Column(name = "precio_venta")
    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Basic
    @Column(name = "cantidad_stock")
    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Basic
    @Column(name = "estado")
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosEntity that = (ProductosEntity) o;
        return Objects.equals(idProducto, that.idProducto) && Objects.equals(nombre, that.nombre) && Objects.equals(codigoBarras, that.codigoBarras) && Objects.equals(precioVenta, that.precioVenta) && Objects.equals(cantidadStock, that.cantidadStock) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre, codigoBarras, precioVenta, cantidadStock, estado);
    }
}
