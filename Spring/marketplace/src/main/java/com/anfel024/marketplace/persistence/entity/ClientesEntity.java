package com.anfel024.marketplace.persistence.entity;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes", schema = "public", catalog = "platzi_spring")
public class ClientesEntity {
    private Long id;
    private String nombre;
    private String apellidos;
    private BigInteger celular;
    private String direccion;
    private String correoElectronico;
    private List<ComprasEntity> mListCompras;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy= "clientesEntity")
    public List<ComprasEntity> getmListCompras() {
        return mListCompras;
    }

    public void setmListCompras(List<ComprasEntity> mListCompras) {
        this.mListCompras = mListCompras;
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
    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "celular")
    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "correo_electronico")
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientesEntity that = (ClientesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(celular, that.celular) && Objects.equals(direccion, that.direccion) && Objects.equals(correoElectronico, that.correoElectronico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, celular, direccion, correoElectronico);
    }
}
