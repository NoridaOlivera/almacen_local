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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AL_MOVIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlMovimiento.findAll", query = "SELECT a FROM AlMovimiento a"),
    @NamedQuery(name = "AlMovimiento.findById", query = "SELECT a FROM AlMovimiento a WHERE a.id = :id"),
    @NamedQuery(name = "AlMovimiento.findByConsecutivo", query = "SELECT a FROM AlMovimiento a WHERE a.consecutivo = :consecutivo"),
    @NamedQuery(name = "AlMovimiento.findByFechaMovimiento", query = "SELECT a FROM AlMovimiento a WHERE a.fechaMovimiento = :fechaMovimiento"),
    @NamedQuery(name = "AlMovimiento.findByIdDependencia", query = "SELECT a FROM AlMovimiento a WHERE a.idDependencia = :idDependencia"),
    @NamedQuery(name = "AlMovimiento.findByIdCentroCostoOrigen", query = "SELECT a FROM AlMovimiento a WHERE a.idCentroCostoOrigen = :idCentroCostoOrigen"),
    @NamedQuery(name = "AlMovimiento.findByIdCentroCostoDestino", query = "SELECT a FROM AlMovimiento a WHERE a.idCentroCostoDestino = :idCentroCostoDestino"),
    @NamedQuery(name = "AlMovimiento.findByIdTercero", query = "SELECT a FROM AlMovimiento a WHERE a.idTercero = :idTercero"),
    @NamedQuery(name = "AlMovimiento.findByEtapa", query = "SELECT a FROM AlMovimiento a WHERE a.etapa = :etapa"),
    @NamedQuery(name = "AlMovimiento.findByIdOrdenCompra", query = "SELECT a FROM AlMovimiento a WHERE a.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "AlMovimiento.findByFechaAprobacion", query = "SELECT a FROM AlMovimiento a WHERE a.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "AlMovimiento.findByObservacion", query = "SELECT a FROM AlMovimiento a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AlMovimiento.findByEmpresa", query = "SELECT a FROM AlMovimiento a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlMovimiento.findByEstadoRegistro", query = "SELECT a FROM AlMovimiento a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlMovimiento.findByUsuarioCreacion", query = "SELECT a FROM AlMovimiento a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlMovimiento.findByUsuarioModificacion", query = "SELECT a FROM AlMovimiento a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlMovimiento.findByFechaCreacion", query = "SELECT a FROM AlMovimiento a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlMovimiento.findByFechaModificacion", query = "SELECT a FROM AlMovimiento a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlMovimiento implements Serializable {

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
    @Column(name = "FECHA_MOVIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEPENDENCIA")
    private BigInteger idDependencia;
    @Column(name = "ID_CENTRO_COSTO_ORIGEN")
    private BigInteger idCentroCostoOrigen;
    @Column(name = "ID_CENTRO_COSTO_DESTINO")
    private BigInteger idCentroCostoDestino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TERCERO")
    private BigInteger idTercero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETAPA")
    private BigInteger etapa;
    @Column(name = "ID_ORDEN_COMPRA")
    private BigInteger idOrdenCompra;
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
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID")
    @ManyToOne
    private AlRequisicion idRequisicion;
    @JoinColumn(name = "ID_BODEGA_ORIGEN", referencedColumnName = "ID")
    @ManyToOne
    private PgBodega idBodegaOrigen;
    @JoinColumn(name = "ID_BODEGA_DESTINO", referencedColumnName = "ID")
    @ManyToOne
    private PgBodega idBodegaDestino;
    @JoinColumn(name = "ID_TIPO_MOVIMIENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PgTipoMovimiento idTipoMovimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMovimiento")
    private List<AlMovimientoDetalle> alMovimientoDetalleList;

    public AlMovimiento() {
    }

    public AlMovimiento(BigDecimal id) {
        this.id = id;
    }

    public AlMovimiento(BigDecimal id, BigInteger consecutivo, Date fechaMovimiento, BigInteger idDependencia, BigInteger idTercero, BigInteger etapa, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.fechaMovimiento = fechaMovimiento;
        this.idDependencia = idDependencia;
        this.idTercero = idTercero;
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

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public BigInteger getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(BigInteger idDependencia) {
        this.idDependencia = idDependencia;
    }

    public BigInteger getIdCentroCostoOrigen() {
        return idCentroCostoOrigen;
    }

    public void setIdCentroCostoOrigen(BigInteger idCentroCostoOrigen) {
        this.idCentroCostoOrigen = idCentroCostoOrigen;
    }

    public BigInteger getIdCentroCostoDestino() {
        return idCentroCostoDestino;
    }

    public void setIdCentroCostoDestino(BigInteger idCentroCostoDestino) {
        this.idCentroCostoDestino = idCentroCostoDestino;
    }

    public BigInteger getIdTercero() {
        return idTercero;
    }

    public void setIdTercero(BigInteger idTercero) {
        this.idTercero = idTercero;
    }

    public BigInteger getEtapa() {
        return etapa;
    }

    public void setEtapa(BigInteger etapa) {
        this.etapa = etapa;
    }

    public BigInteger getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(BigInteger idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
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

    public AlRequisicion getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(AlRequisicion idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public PgBodega getIdBodegaOrigen() {
        return idBodegaOrigen;
    }

    public void setIdBodegaOrigen(PgBodega idBodegaOrigen) {
        this.idBodegaOrigen = idBodegaOrigen;
    }

    public PgBodega getIdBodegaDestino() {
        return idBodegaDestino;
    }

    public void setIdBodegaDestino(PgBodega idBodegaDestino) {
        this.idBodegaDestino = idBodegaDestino;
    }

    public PgTipoMovimiento getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(PgTipoMovimiento idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    @XmlTransient
    public List<AlMovimientoDetalle> getAlMovimientoDetalleList() {
        return alMovimientoDetalleList;
    }

    public void setAlMovimientoDetalleList(List<AlMovimientoDetalle> alMovimientoDetalleList) {
        this.alMovimientoDetalleList = alMovimientoDetalleList;
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
        if (!(object instanceof AlMovimiento)) {
            return false;
        }
        AlMovimiento other = (AlMovimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlMovimiento[ id=" + id + " ]";
    }
    
}
