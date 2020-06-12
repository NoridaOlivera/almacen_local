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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 57311
 */
@Entity
@Table(name = "PG_CONSECUTIVO_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgConsecutivoDetalle.findAll", query = "SELECT p FROM PgConsecutivoDetalle p"),
    @NamedQuery(name = "PgConsecutivoDetalle.findById", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.id = :id"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByFechaInicial", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByFechaFinal", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByValorActual", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.valorActual = :valorActual"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByEmpresa", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByEstadoRegistro", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByUsuarioCreacion", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByUsuarioModificacion", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByFechaCreacion", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PgConsecutivoDetalle.findByFechaModificacion", query = "SELECT p FROM PgConsecutivoDetalle p WHERE p.fechaModificacion = :fechaModificacion")})
public class PgConsecutivoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_ACTUAL")
    private BigInteger valorActual;
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
    @JoinColumn(name = "ID_CONSECUTIVO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PgConsecutivo idConsecutivo;

    public PgConsecutivoDetalle() {
    }

    public PgConsecutivoDetalle(BigDecimal id) {
        this.id = id;
    }

    public PgConsecutivoDetalle(BigDecimal id, Date fechaInicial, Date fechaFinal, BigInteger valorActual, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.valorActual = valorActual;
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

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public BigInteger getValorActual() {
        return valorActual;
    }

    public void setValorActual(BigInteger valorActual) {
        this.valorActual = valorActual;
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

    public PgConsecutivo getIdConsecutivo() {
        return idConsecutivo;
    }

    public void setIdConsecutivo(PgConsecutivo idConsecutivo) {
        this.idConsecutivo = idConsecutivo;
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
        if (!(object instanceof PgConsecutivoDetalle)) {
            return false;
        }
        PgConsecutivoDetalle other = (PgConsecutivoDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.PgConsecutivoDetalle[ id=" + id + " ]";
    }
    
}
