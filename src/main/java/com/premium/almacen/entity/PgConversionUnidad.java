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
@Table(name = "PG_CONVERSION_UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgConversionUnidad.findAll", query = "SELECT p FROM PgConversionUnidad p"),
    @NamedQuery(name = "PgConversionUnidad.findById", query = "SELECT p FROM PgConversionUnidad p WHERE p.id = :id"),
    @NamedQuery(name = "PgConversionUnidad.findByNombre", query = "SELECT p FROM PgConversionUnidad p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PgConversionUnidad.findByDescripcion", query = "SELECT p FROM PgConversionUnidad p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PgConversionUnidad.findByValorConversion", query = "SELECT p FROM PgConversionUnidad p WHERE p.valorConversion = :valorConversion"),
    @NamedQuery(name = "PgConversionUnidad.findByEmpresa", query = "SELECT p FROM PgConversionUnidad p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "PgConversionUnidad.findByEstadoRegistro", query = "SELECT p FROM PgConversionUnidad p WHERE p.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "PgConversionUnidad.findByUsuarioCreacion", query = "SELECT p FROM PgConversionUnidad p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PgConversionUnidad.findByUsuarioModificacion", query = "SELECT p FROM PgConversionUnidad p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "PgConversionUnidad.findByFechaCreacion", query = "SELECT p FROM PgConversionUnidad p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PgConversionUnidad.findByFechaModificacion", query = "SELECT p FROM PgConversionUnidad p WHERE p.fechaModificacion = :fechaModificacion")})
public class PgConversionUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
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
    @Column(name = "VALOR_CONVERSION")
    private BigInteger valorConversion;
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
    @OneToMany(mappedBy = "idConversionUnidad")
    private List<AlProducto> alProductoList;
    @JoinColumn(name = "ID_UNIDAD_MEDIDA_INICIAL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PgUnidadMedida idUnidadMedidaInicial;
    @JoinColumn(name = "ID_UNIDAD_MEDIDA_FINAL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PgUnidadMedida idUnidadMedidaFinal;

    public PgConversionUnidad() {
    }

    public PgConversionUnidad(BigDecimal id) {
        this.id = id;
    }

    public PgConversionUnidad(BigDecimal id, String nombre, BigInteger valorConversion, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.valorConversion = valorConversion;
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

    public BigInteger getValorConversion() {
        return valorConversion;
    }

    public void setValorConversion(BigInteger valorConversion) {
        this.valorConversion = valorConversion;
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
    public List<AlProducto> getAlProductoList() {
        return alProductoList;
    }

    public void setAlProductoList(List<AlProducto> alProductoList) {
        this.alProductoList = alProductoList;
    }

    public PgUnidadMedida getIdUnidadMedidaInicial() {
        return idUnidadMedidaInicial;
    }

    public void setIdUnidadMedidaInicial(PgUnidadMedida idUnidadMedidaInicial) {
        this.idUnidadMedidaInicial = idUnidadMedidaInicial;
    }

    public PgUnidadMedida getIdUnidadMedidaFinal() {
        return idUnidadMedidaFinal;
    }

    public void setIdUnidadMedidaFinal(PgUnidadMedida idUnidadMedidaFinal) {
        this.idUnidadMedidaFinal = idUnidadMedidaFinal;
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
        if (!(object instanceof PgConversionUnidad)) {
            return false;
        }
        PgConversionUnidad other = (PgConversionUnidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.PgConversionUnidad[ id=" + id + " ]";
    }
    
}
