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
@Table(name = "AL_ORDEN_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlOrdenCompra.findAll", query = "SELECT a FROM AlOrdenCompra a"),
    @NamedQuery(name = "AlOrdenCompra.findById", query = "SELECT a FROM AlOrdenCompra a WHERE a.id = :id"),
    @NamedQuery(name = "AlOrdenCompra.findByConsecutivo", query = "SELECT a FROM AlOrdenCompra a WHERE a.consecutivo = :consecutivo"),
    @NamedQuery(name = "AlOrdenCompra.findByFechaEmision", query = "SELECT a FROM AlOrdenCompra a WHERE a.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "AlOrdenCompra.findByIdDependencia", query = "SELECT a FROM AlOrdenCompra a WHERE a.idDependencia = :idDependencia"),
    @NamedQuery(name = "AlOrdenCompra.findByTipoOrdenCompra", query = "SELECT a FROM AlOrdenCompra a WHERE a.tipoOrdenCompra = :tipoOrdenCompra"),
    @NamedQuery(name = "AlOrdenCompra.findByIdCentroCosto", query = "SELECT a FROM AlOrdenCompra a WHERE a.idCentroCosto = :idCentroCosto"),
    @NamedQuery(name = "AlOrdenCompra.findByIdProveedor", query = "SELECT a FROM AlOrdenCompra a WHERE a.idProveedor = :idProveedor"),
    @NamedQuery(name = "AlOrdenCompra.findByEtapa", query = "SELECT a FROM AlOrdenCompra a WHERE a.etapa = :etapa"),
    @NamedQuery(name = "AlOrdenCompra.findByObservacion", query = "SELECT a FROM AlOrdenCompra a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AlOrdenCompra.findByEmpresa", query = "SELECT a FROM AlOrdenCompra a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlOrdenCompra.findByEstadoRegistro", query = "SELECT a FROM AlOrdenCompra a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlOrdenCompra.findByUsuarioCreacion", query = "SELECT a FROM AlOrdenCompra a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlOrdenCompra.findByUsuarioModificacion", query = "SELECT a FROM AlOrdenCompra a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlOrdenCompra.findByFechaCreacion", query = "SELECT a FROM AlOrdenCompra a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlOrdenCompra.findByFechaModificacion", query = "SELECT a FROM AlOrdenCompra a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlOrdenCompra implements Serializable {

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
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEPENDENCIA")
    private BigInteger idDependencia;
    @Size(max = 64)
    @Column(name = "TIPO_ORDEN_COMPRA")
    private String tipoOrdenCompra;
    @Column(name = "ID_CENTRO_COSTO")
    private BigInteger idCentroCosto;
    @Column(name = "ID_PROVEEDOR")
    private BigInteger idProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETAPA")
    private BigInteger etapa;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenCompra")
    private List<AlOrdenCompraDetalle> alOrdenCompraDetalleList;
    @JoinColumn(name = "ID_BODEGA_DESTINO", referencedColumnName = "ID")
    @ManyToOne
    private PgBodega idBodegaDestino;

    public AlOrdenCompra() {
    }

    public AlOrdenCompra(BigDecimal id) {
        this.id = id;
    }

    public AlOrdenCompra(BigDecimal id, BigInteger consecutivo, Date fechaEmision, BigInteger idDependencia, BigInteger etapa, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.fechaEmision = fechaEmision;
        this.idDependencia = idDependencia;
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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigInteger getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(BigInteger idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getTipoOrdenCompra() {
        return tipoOrdenCompra;
    }

    public void setTipoOrdenCompra(String tipoOrdenCompra) {
        this.tipoOrdenCompra = tipoOrdenCompra;
    }

    public BigInteger getIdCentroCosto() {
        return idCentroCosto;
    }

    public void setIdCentroCosto(BigInteger idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    public BigInteger getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigInteger idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigInteger getEtapa() {
        return etapa;
    }

    public void setEtapa(BigInteger etapa) {
        this.etapa = etapa;
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
    public List<AlOrdenCompraDetalle> getAlOrdenCompraDetalleList() {
        return alOrdenCompraDetalleList;
    }

    public void setAlOrdenCompraDetalleList(List<AlOrdenCompraDetalle> alOrdenCompraDetalleList) {
        this.alOrdenCompraDetalleList = alOrdenCompraDetalleList;
    }

    public PgBodega getIdBodegaDestino() {
        return idBodegaDestino;
    }

    public void setIdBodegaDestino(PgBodega idBodegaDestino) {
        this.idBodegaDestino = idBodegaDestino;
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
        if (!(object instanceof AlOrdenCompra)) {
            return false;
        }
        AlOrdenCompra other = (AlOrdenCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlOrdenCompra[ id=" + id + " ]";
    }
    
}
