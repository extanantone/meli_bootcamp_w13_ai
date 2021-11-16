package com.anfel024.marketplace.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "compras", schema = "public", catalog = "platzi_spring")
public class ComprasEntity {
    private Long idCompra;
    private Integer idCliente;
    private LocalDate fecha;
    private String medioPago;
    private String comentario;
    private String estado;
    private ClientesEntity clientesEntity;
    private List<ComprasProductosEntity> mListaCompraProductos;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_compra")
    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    @Column(name = "id_cliente")
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCompra) {
        this.idCliente = idCompra;
    }

    @OneToMany(mappedBy= "productosEntity")
    public List<ComprasProductosEntity> getmListaCompraProductos() {
        return mListaCompraProductos;
    }

    public void setmListaCompraProductos(List<ComprasProductosEntity> mListaCompraProductos) {
        this.mListaCompraProductos = mListaCompraProductos;
    }

    @ManyToOne
    @JoinColumn(name= "id_cliente", insertable = false, updatable = false)
    public ClientesEntity getClientesEntity() {
        return clientesEntity;
    }

    public void setClientesEntity(ClientesEntity clientesEntity) {
        this.clientesEntity = clientesEntity;
    }

    @Basic
    @Column(name = "fecha")
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "medio_pago")
    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @Basic
    @Column(name = "comentario")
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComprasEntity that = (ComprasEntity) o;
        return Objects.equals(idCompra, that.idCompra) && Objects.equals(fecha, that.fecha) && Objects.equals(medioPago, that.medioPago) && Objects.equals(comentario, that.comentario) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompra, fecha, medioPago, comentario, estado);
    }
}
