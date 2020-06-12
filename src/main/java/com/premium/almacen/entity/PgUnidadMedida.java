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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "PG_UNIDAD_MEDIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgUnidadMedida.findAll", query = "SELECT p FROM PgUnidadMedida p"),
    @NamedQuery(name = "PgUnidadMedida.findById", query = "SELECT p FROM PgUnidadMedida p WHERE p.id = :id"),
    @NamedQuery(name = "PgUnidadMedida.findByNombre", query = "SELECT p FROM PgUnidadMedida p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PgUnidadMedida.findByDescripcion", query = "SELECT p FROM PgUnidadMedida p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PgUnidadMedida.findByAbreviatura", query = "SELECT p FROM PgUnidadMedida p WHERE p.abreviatura = :abreviatura"),
    @NamedQuery(name = "PgUnidadMedida.findByEmpresa", query = "SELECT p FROM PgUnidadMedida p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "PgUnidadMedida.findByEstadoRegistro", query = "SELECT p FROM PgUnidadMedida p WHERE p.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "PgUnidadMedida.findByUsuarioCreacion", query = "SELECT p FROM PgUnidadMedida p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PgUnidadMedida.findByUsuarioModificacion", query = "SELECT p FROM PgUnidadMedida p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "PgUnidadMedida.findByFechaCreacion", query = "SELECT p FROM PgUnidadMedida p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PgUnidadMedida.findByFechaModificacion", query = "SELECT p FROM PgUnidadMedida p WHERE p.fechaModificacion = :fechaModificacion")})
public class PgUnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PG_UNIDAD_MEDIDA")
    @SequenceGenerator(name = "SQ_PG_UNIDAD_MEDIDA", sequenceName = "SQ_PG_UNIDAD_MEDIDA", allocationSize = 1)
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
    @Size(min = 1, max = 16)
    @Column(name = "ABREVIATURA")
    private String abreviatura;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedidaInicial")
    private List<PgConversionUnidad> pgConversionUnidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedidaFinal")
    private List<PgConversionUnidad> pgConversionUnidadList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    private List<AlMovimientoDetalle> alMovimientoDetalleList;

    public PgUnidadMedida() {
    }

    public PgUnidadMedida(BigDecimal id) {
        this.id = id;
    }

    public PgUnidadMedida(BigDecimal id, String nombre, String abreviatura, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
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
    public List<PgConversionUnidad> getPgConversionUnidadList() {
        return pgConversionUnidadList;
    }

    public void setPgConversionUnidadList(List<PgConversionUnidad> pgConversionUnidadList) {
        this.pgConversionUnidadList = pgConversionUnidadList;
    }

    @XmlTransient
    public List<PgConversionUnidad> getPgConversionUnidadList1() {
        return pgConversionUnidadList1;
    }

    public void setPgConversionUnidadList1(List<PgConversionUnidad> pgConversionUnidadList1) {
        this.pgConversionUnidadList1 = pgConversionUnidadList1;
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
        if (!(object instanceof PgUnidadMedida)) {
            return false;
        }
        PgUnidadMedida other = (PgUnidadMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.PgUnidadMedida[ id=" + id + " ]";
    }
    
}
