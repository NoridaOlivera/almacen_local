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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AL_REQUISICION_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlRequisicionDetalle.findAll", query = "SELECT a FROM AlRequisicionDetalle a"),
    @NamedQuery(name = "AlRequisicionDetalle.findById", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.id = :id"),
    @NamedQuery(name = "AlRequisicionDetalle.findByItem", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.item = :item"),
    @NamedQuery(name = "AlRequisicionDetalle.findByNombreProducto", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "AlRequisicionDetalle.findByIdUnidadMedidaDespacho", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.idUnidadMedidaDespacho = :idUnidadMedidaDespacho"),
    @NamedQuery(name = "AlRequisicionDetalle.findByCantidadProducto", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "AlRequisicionDetalle.findByValorUnitario", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "AlRequisicionDetalle.findByObservacion", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AlRequisicionDetalle.findByEmpresa", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlRequisicionDetalle.findByEstadoRegistro", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlRequisicionDetalle.findByUsuarioCreacion", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlRequisicionDetalle.findByUsuarioModificacion", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlRequisicionDetalle.findByFechaCreacion", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlRequisicionDetalle.findByFechaModificacion", query = "SELECT a FROM AlRequisicionDetalle a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlRequisicionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM")
    private BigInteger item;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2048)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD_MEDIDA_DESPACHO")
    private BigInteger idUnidadMedidaDespacho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private BigInteger cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_UNITARIO")
    private BigInteger valorUnitario;
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
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AlProducto idProducto;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AlRequisicion idRequisicion;

    public AlRequisicionDetalle() {
    }

    public AlRequisicionDetalle(BigDecimal id) {
        this.id = id;
    }

    public AlRequisicionDetalle(BigDecimal id, BigInteger item, String nombreProducto, BigInteger idUnidadMedidaDespacho, BigInteger cantidadProducto, BigInteger valorUnitario, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.item = item;
        this.nombreProducto = nombreProducto;
        this.idUnidadMedidaDespacho = idUnidadMedidaDespacho;
        this.cantidadProducto = cantidadProducto;
        this.valorUnitario = valorUnitario;
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

    public BigInteger getItem() {
        return item;
    }

    public void setItem(BigInteger item) {
        this.item = item;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigInteger getIdUnidadMedidaDespacho() {
        return idUnidadMedidaDespacho;
    }

    public void setIdUnidadMedidaDespacho(BigInteger idUnidadMedidaDespacho) {
        this.idUnidadMedidaDespacho = idUnidadMedidaDespacho;
    }

    public BigInteger getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigInteger cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public BigInteger getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigInteger valorUnitario) {
        this.valorUnitario = valorUnitario;
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

    public AlProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(AlProducto idProducto) {
        this.idProducto = idProducto;
    }

    public AlRequisicion getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(AlRequisicion idRequisicion) {
        this.idRequisicion = idRequisicion;
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
        if (!(object instanceof AlRequisicionDetalle)) {
            return false;
        }
        AlRequisicionDetalle other = (AlRequisicionDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlRequisicionDetalle[ id=" + id + " ]";
    }
    
}
