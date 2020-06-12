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
@Table(name = "AL_ORDEN_COMPRA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlOrdenCompraDetalle.findAll", query = "SELECT a FROM AlOrdenCompraDetalle a"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findById", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.id = :id"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByItem", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.item = :item"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByNombreProducto", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByIdUnidadMedidaDespacho", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.idUnidadMedidaDespacho = :idUnidadMedidaDespacho"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByCantidadProducto", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByValorUnitario", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByDescuento", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.descuento = :descuento"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByValorIva", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.valorIva = :valorIva"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByValorImpuestoConsumo", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.valorImpuestoConsumo = :valorImpuestoConsumo"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByValorOtroImpuesto1", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.valorOtroImpuesto1 = :valorOtroImpuesto1"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByValorOtroImpuesto2", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.valorOtroImpuesto2 = :valorOtroImpuesto2"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByTotal", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.total = :total"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByObservacion", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByEmpresa", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByEstadoRegistro", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByUsuarioCreacion", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByUsuarioModificacion", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByFechaCreacion", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlOrdenCompraDetalle.findByFechaModificacion", query = "SELECT a FROM AlOrdenCompraDetalle a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlOrdenCompraDetalle implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_IVA")
    private BigInteger valorIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_IMPUESTO_CONSUMO")
    private BigInteger valorImpuestoConsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_OTRO_IMPUESTO1")
    private BigInteger valorOtroImpuesto1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_OTRO_IMPUESTO2")
    private BigInteger valorOtroImpuesto2;
    @Column(name = "TOTAL")
    private BigInteger total;
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
    @JoinColumn(name = "ID_ORDEN_COMPRA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AlOrdenCompra idOrdenCompra;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AlProducto idProducto;

    public AlOrdenCompraDetalle() {
    }

    public AlOrdenCompraDetalle(BigDecimal id) {
        this.id = id;
    }

    public AlOrdenCompraDetalle(BigDecimal id, BigInteger item, String nombreProducto, BigInteger idUnidadMedidaDespacho, BigInteger cantidadProducto, BigInteger valorUnitario, BigDecimal descuento, BigInteger valorIva, BigInteger valorImpuestoConsumo, BigInteger valorOtroImpuesto1, BigInteger valorOtroImpuesto2, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.item = item;
        this.nombreProducto = nombreProducto;
        this.idUnidadMedidaDespacho = idUnidadMedidaDespacho;
        this.cantidadProducto = cantidadProducto;
        this.valorUnitario = valorUnitario;
        this.descuento = descuento;
        this.valorIva = valorIva;
        this.valorImpuestoConsumo = valorImpuestoConsumo;
        this.valorOtroImpuesto1 = valorOtroImpuesto1;
        this.valorOtroImpuesto2 = valorOtroImpuesto2;
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

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigInteger getValorIva() {
        return valorIva;
    }

    public void setValorIva(BigInteger valorIva) {
        this.valorIva = valorIva;
    }

    public BigInteger getValorImpuestoConsumo() {
        return valorImpuestoConsumo;
    }

    public void setValorImpuestoConsumo(BigInteger valorImpuestoConsumo) {
        this.valorImpuestoConsumo = valorImpuestoConsumo;
    }

    public BigInteger getValorOtroImpuesto1() {
        return valorOtroImpuesto1;
    }

    public void setValorOtroImpuesto1(BigInteger valorOtroImpuesto1) {
        this.valorOtroImpuesto1 = valorOtroImpuesto1;
    }

    public BigInteger getValorOtroImpuesto2() {
        return valorOtroImpuesto2;
    }

    public void setValorOtroImpuesto2(BigInteger valorOtroImpuesto2) {
        this.valorOtroImpuesto2 = valorOtroImpuesto2;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
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

    public AlOrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(AlOrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public AlProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(AlProducto idProducto) {
        this.idProducto = idProducto;
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
        if (!(object instanceof AlOrdenCompraDetalle)) {
            return false;
        }
        AlOrdenCompraDetalle other = (AlOrdenCompraDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlOrdenCompraDetalle[ id=" + id + " ]";
    }
    
}
