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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 57311
 */
@Entity
@Table(name = "PG_CONSECUTIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgConsecutivo.findAll", query = "SELECT p FROM PgConsecutivo p"),
    @NamedQuery(name = "PgConsecutivo.findById", query = "SELECT p FROM PgConsecutivo p WHERE p.id = :id"),
    @NamedQuery(name = "PgConsecutivo.findByDescripcion", query = "SELECT p FROM PgConsecutivo p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PgConsecutivo.findByReinicio", query = "SELECT p FROM PgConsecutivo p WHERE p.reinicio = :reinicio"),
    @NamedQuery(name = "PgConsecutivo.findByEmpresa", query = "SELECT p FROM PgConsecutivo p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "PgConsecutivo.findByEstadoRegistro", query = "SELECT p FROM PgConsecutivo p WHERE p.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "PgConsecutivo.findByUsuarioCreacion", query = "SELECT p FROM PgConsecutivo p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PgConsecutivo.findByUsuarioModificacion", query = "SELECT p FROM PgConsecutivo p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "PgConsecutivo.findByFechaCreacion", query = "SELECT p FROM PgConsecutivo p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PgConsecutivo.findByFechaModificacion", query = "SELECT p FROM PgConsecutivo p WHERE p.fechaModificacion = :fechaModificacion")})
public class PgConsecutivo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REINICIO")
    private Character reinicio;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsecutivo")
    private List<PgConsecutivoDetalle> pgConsecutivoDetalleList;

    public PgConsecutivo() {
    }

    public PgConsecutivo(BigDecimal id) {
        this.id = id;
    }

    public PgConsecutivo(BigDecimal id, String descripcion, Character reinicio, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.reinicio = reinicio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getReinicio() {
        return reinicio;
    }

    public void setReinicio(Character reinicio) {
        this.reinicio = reinicio;
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

    @XmlTransient
    public List<PgConsecutivoDetalle> getPgConsecutivoDetalleList() {
        return pgConsecutivoDetalleList;
    }

    public void setPgConsecutivoDetalleList(List<PgConsecutivoDetalle> pgConsecutivoDetalleList) {
        this.pgConsecutivoDetalleList = pgConsecutivoDetalleList;
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
        if (!(object instanceof PgConsecutivo)) {
            return false;
        }
        PgConsecutivo other = (PgConsecutivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.PgConsecutivo[ id=" + id + " ]";
    }
    
}
