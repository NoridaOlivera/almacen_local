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
@Table(name = "AL_GRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlGrupo.findAll", query = "SELECT a FROM AlGrupo a"),
    @NamedQuery(name = "AlGrupo.findById", query = "SELECT a FROM AlGrupo a WHERE a.id = :id"),
    @NamedQuery(name = "AlGrupo.findByCodigo", query = "SELECT a FROM AlGrupo a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "AlGrupo.findByNombre", query = "SELECT a FROM AlGrupo a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AlGrupo.findByDescripcion", query = "SELECT a FROM AlGrupo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AlGrupo.findByNivel", query = "SELECT a FROM AlGrupo a WHERE a.nivel = :nivel"),
    @NamedQuery(name = "AlGrupo.findByEmpresa", query = "SELECT a FROM AlGrupo a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlGrupo.findByEstadoRegistro", query = "SELECT a FROM AlGrupo a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlGrupo.findByUsuarioCreacion", query = "SELECT a FROM AlGrupo a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlGrupo.findByUsuarioModificacion", query = "SELECT a FROM AlGrupo a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlGrupo.findByFechaCreacion", query = "SELECT a FROM AlGrupo a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlGrupo.findByFechaModificacion", query = "SELECT a FROM AlGrupo a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlGrupo implements Serializable {

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
    @Column(name = "NIVEL")
    private BigInteger nivel;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private List<AlProducto> alProductoList;
    @OneToMany(mappedBy = "padre")
    private List<AlGrupo> alGrupoList;
    @JoinColumn(name = "PADRE", referencedColumnName = "ID")
    @ManyToOne
    private AlGrupo padre;

    public AlGrupo() {
    }

    public AlGrupo(BigDecimal id) {
        this.id = id;
    }

    public AlGrupo(BigDecimal id, String codigo, String nombre, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
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

    public BigInteger getNivel() {
        return nivel;
    }

    public void setNivel(BigInteger nivel) {
        this.nivel = nivel;
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

    @XmlTransient
    public List<AlGrupo> getAlGrupoList() {
        return alGrupoList;
    }

    public void setAlGrupoList(List<AlGrupo> alGrupoList) {
        this.alGrupoList = alGrupoList;
    }

    public AlGrupo getPadre() {
        return padre;
    }

    public void setPadre(AlGrupo padre) {
        this.padre = padre;
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
        if (!(object instanceof AlGrupo)) {
            return false;
        }
        AlGrupo other = (AlGrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlGrupo[ id=" + id + " ]";
    }
    
}
