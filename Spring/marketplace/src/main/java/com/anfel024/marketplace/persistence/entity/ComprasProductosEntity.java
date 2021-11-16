package com.anfel024.marketplace.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "compras_productos", schema = "public", catalog = "platzi_spring")
public class ComprasProductosEntity {
    private ComprasProductosEntityPK id;
    private Integer cantidad;
    private BigDecimal total;
    private Boolean estado;
    private ComprasEntity comprasEntity;
    private ProductosEntity productosEntity;

    @EmbeddedId
    public ComprasProductosEntityPK getId() {
        return id;
    }

    public void setId(ComprasProductosEntityPK id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name= "id_compra", insertable = false, updatable = false)
    public ComprasEntity getComprasEntity() {
        return comprasEntity;
    }

    public void setComprasEntity(ComprasEntity comprasEntity) {
        this.comprasEntity = comprasEntity;
    }

    @ManyToOne
    @JoinColumn(name= "id_producto", insertable = false, updatable = false)
    public ProductosEntity getProductosEntity() {
        return productosEntity;
    }

    public void setProductosEntity(ProductosEntity productosEntity) {
        this.productosEntity = productosEntity;
    }

    @Basic
    @Column(name = "cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "total")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
        ComprasProductosEntity that = (ComprasProductosEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(cantidad, that.cantidad)
                && Objects.equals(total, that.total)
                && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, total, estado);
    }
}
