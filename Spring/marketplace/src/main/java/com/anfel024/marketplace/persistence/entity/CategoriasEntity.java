package com.anfel024.marketplace.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categorias", schema = "public", catalog = "platzi_spring")
public class CategoriasEntity {
    private Integer idCategoria;
    private String descripcion;
    private Boolean estado;
    private List<ProductosEntity> mListaProductos;

    @OneToMany(mappedBy = "categoriasEntity")
    public List<ProductosEntity> getmListaProductos() {
        return mListaProductos;
    }

    public void setmListaProductos(List<ProductosEntity> mListaProductos) {
        this.mListaProductos = mListaProductos;
    }

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        CategoriasEntity that = (CategoriasEntity) o;
        return Objects.equals(idCategoria, that.idCategoria) && Objects.equals(descripcion, that.descripcion) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, descripcion, estado);
    }
}
