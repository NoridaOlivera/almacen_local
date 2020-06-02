/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 57311
 */
@Entity
@Table(name = "PG_MARCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgMarca.findAll", query = "SELECT p FROM PgMarca p"),
    @NamedQuery(name = "PgMarca.findById", query = "SELECT p FROM PgMarca p WHERE p.id = :id"),
    @NamedQuery(name = "PgMarca.findByCodigo", query = "SELECT p FROM PgMarca p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "PgMarca.findByNombre", query = "SELECT p FROM PgMarca p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PgMarca.findByDescripcion", query = "SELECT p FROM PgMarca p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PgMarca.findByEmpresa", query = "SELECT p FROM PgMarca p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "PgMarca.findByEstadoRegistro", query = "SELECT p FROM PgMarca p WHERE p.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "PgMarca.findByUsuarioCreacion", query = "SELECT p FROM PgMarca p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PgMarca.findByUsuarioModificacion", query = "SELECT p FROM PgMarca p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "PgMarca.findByFechaCreacion", query = "SELECT p FROM PgMarca p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PgMarca.findByFechaModificacion", query = "SELECT p FROM PgMarca p WHERE p.fechaModificacion = :fechaModificacion")})
public class PgMarca implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2048)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 2048)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPRESA")
    private BigInteger empresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_REGISTRO")
    private short estadoRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_CREACION")
    private BigInteger usuarioCreacion;
    @Column(name = "USUARIO_MODIFICACION")
    private BigInteger usuarioModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public PgMarca() {
    }

    public PgMarca(BigDecimal id) {
        this.id = id;
    }

    public PgMarca(BigDecimal id, String codigo, String nombre, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.empresa = empresa;
        this.estadoRegistro = estadoRegistro;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getEmpresa() {
        return empresa;
    }

    public void setEmpresa(BigInteger empresa) {
        this.empresa = empresa;
    }

    public short getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(short estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public BigInteger getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(BigInteger usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public BigInteger getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(BigInteger usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgMarca)) {
            return false;
        }
        PgMarca other = (PgMarca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.PgMarca[ id=" + id + " ]";
    }
    
}
