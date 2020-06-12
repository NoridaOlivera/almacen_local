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
@Table(name = "AL_REQUISICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlRequisicion.findAll", query = "SELECT a FROM AlRequisicion a"),
    @NamedQuery(name = "AlRequisicion.findById", query = "SELECT a FROM AlRequisicion a WHERE a.id = :id"),
    @NamedQuery(name = "AlRequisicion.findByConsecutivo", query = "SELECT a FROM AlRequisicion a WHERE a.consecutivo = :consecutivo"),
    @NamedQuery(name = "AlRequisicion.findByFechaRequisicion", query = "SELECT a FROM AlRequisicion a WHERE a.fechaRequisicion = :fechaRequisicion"),
    @NamedQuery(name = "AlRequisicion.findByIdDependencia", query = "SELECT a FROM AlRequisicion a WHERE a.idDependencia = :idDependencia"),
    @NamedQuery(name = "AlRequisicion.findByIdCliente", query = "SELECT a FROM AlRequisicion a WHERE a.idCliente = :idCliente"),
    @NamedQuery(name = "AlRequisicion.findByEtapa", query = "SELECT a FROM AlRequisicion a WHERE a.etapa = :etapa"),
    @NamedQuery(name = "AlRequisicion.findByFechaAprobacion", query = "SELECT a FROM AlRequisicion a WHERE a.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "AlRequisicion.findByObservacion", query = "SELECT a FROM AlRequisicion a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AlRequisicion.findByEmpresa", query = "SELECT a FROM AlRequisicion a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlRequisicion.findByEstadoRegistro", query = "SELECT a FROM AlRequisicion a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlRequisicion.findByUsuarioCreacion", query = "SELECT a FROM AlRequisicion a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlRequisicion.findByUsuarioModificacion", query = "SELECT a FROM AlRequisicion a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlRequisicion.findByFechaCreacion", query = "SELECT a FROM AlRequisicion a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlRequisicion.findByFechaModificacion", query = "SELECT a FROM AlRequisicion a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlRequisicion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSECUTIVO")
    private BigInteger consecutivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REQUISICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRequisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEPENDENCIA")
    private BigInteger idDependencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETAPA")
    private BigInteger etapa;
    @Column(name = "FECHA_APROBACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @Size(max = 2048)
    @Column(name = "OBSERVACION")
    private String observacion;
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
    @OneToMany(mappedBy = "idRequisicion")
    private List<AlMovimiento> alMovimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisicion")
    private List<AlRequisicionDetalle> alRequisicionDetalleList;

    public AlRequisicion() {
    }

    public AlRequisicion(BigDecimal id) {
        this.id = id;
    }

    public AlRequisicion(BigDecimal id, BigInteger consecutivo, Date fechaRequisicion, BigInteger idDependencia, BigInteger idCliente, BigInteger etapa, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.fechaRequisicion = fechaRequisicion;
        this.idDependencia = idDependencia;
        this.idCliente = idCliente;
        this.etapa = etapa;
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

    public BigInteger getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(BigInteger consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFechaRequisicion() {
        return fechaRequisicion;
    }

    public void setFechaRequisicion(Date fechaRequisicion) {
        this.fechaRequisicion = fechaRequisicion;
    }

    public BigInteger getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(BigInteger idDependencia) {
        this.idDependencia = idDependencia;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getEtapa() {
        return etapa;
    }

    public void setEtapa(BigInteger etapa) {
        this.etapa = etapa;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
    public List<AlMovimiento> getAlMovimientoList() {
        return alMovimientoList;
    }

    public void setAlMovimientoList(List<AlMovimiento> alMovimientoList) {
        this.alMovimientoList = alMovimientoList;
    }

    @XmlTransient
    public List<AlRequisicionDetalle> getAlRequisicionDetalleList() {
        return alRequisicionDetalleList;
    }

    public void setAlRequisicionDetalleList(List<AlRequisicionDetalle> alRequisicionDetalleList) {
        this.alRequisicionDetalleList = alRequisicionDetalleList;
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
        if (!(object instanceof AlRequisicion)) {
            return false;
        }
        AlRequisicion other = (AlRequisicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlRequisicion[ id=" + id + " ]";
    }
    
}
