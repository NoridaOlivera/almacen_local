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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AL_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlProducto.findAll", query = "SELECT a FROM AlProducto a"),
    @NamedQuery(name = "AlProducto.findById", query = "SELECT a FROM AlProducto a WHERE a.id = :id"),
    @NamedQuery(name = "AlProducto.findByCodigo", query = "SELECT a FROM AlProducto a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "AlProducto.findByNombre", query = "SELECT a FROM AlProducto a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AlProducto.findByDescripcion", query = "SELECT a FROM AlProducto a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AlProducto.findByIdUnidadMedida", query = "SELECT a FROM AlProducto a WHERE a.idUnidadMedida = :idUnidadMedida"),
    @NamedQuery(name = "AlProducto.findByCodigoQr", query = "SELECT a FROM AlProducto a WHERE a.codigoQr = :codigoQr"),
    @NamedQuery(name = "AlProducto.findByReferencia", query = "SELECT a FROM AlProducto a WHERE a.referencia = :referencia"),
    @NamedQuery(name = "AlProducto.findByManejaLote", query = "SELECT a FROM AlProducto a WHERE a.manejaLote = :manejaLote"),
    @NamedQuery(name = "AlProducto.findByNombreLote", query = "SELECT a FROM AlProducto a WHERE a.nombreLote = :nombreLote"),
    @NamedQuery(name = "AlProducto.findByGarantia", query = "SELECT a FROM AlProducto a WHERE a.garantia = :garantia"),
    @NamedQuery(name = "AlProducto.findByCaracteristicas", query = "SELECT a FROM AlProducto a WHERE a.caracteristicas = :caracteristicas"),
    @NamedQuery(name = "AlProducto.findByImagen", query = "SELECT a FROM AlProducto a WHERE a.imagen = :imagen"),
    @NamedQuery(name = "AlProducto.findByInventario", query = "SELECT a FROM AlProducto a WHERE a.inventario = :inventario"),
    @NamedQuery(name = "AlProducto.findByActivoFijo", query = "SELECT a FROM AlProducto a WHERE a.activoFijo = :activoFijo"),
    @NamedQuery(name = "AlProducto.findByStockMinimo", query = "SELECT a FROM AlProducto a WHERE a.stockMinimo = :stockMinimo"),
    @NamedQuery(name = "AlProducto.findByStockMaximo", query = "SELECT a FROM AlProducto a WHERE a.stockMaximo = :stockMaximo"),
    @NamedQuery(name = "AlProducto.findByCompuesto", query = "SELECT a FROM AlProducto a WHERE a.compuesto = :compuesto"),
    @NamedQuery(name = "AlProducto.findByEmpresa", query = "SELECT a FROM AlProducto a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "AlProducto.findByEstadoRegistro", query = "SELECT a FROM AlProducto a WHERE a.estadoRegistro = :estadoRegistro"),
    @NamedQuery(name = "AlProducto.findByUsuarioCreacion", query = "SELECT a FROM AlProducto a WHERE a.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "AlProducto.findByUsuarioModificacion", query = "SELECT a FROM AlProducto a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AlProducto.findByFechaCreacion", query = "SELECT a FROM AlProducto a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AlProducto.findByFechaModificacion", query = "SELECT a FROM AlProducto a WHERE a.fechaModificacion = :fechaModificacion")})
public class AlProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AL_PRODUCTO")
    @SequenceGenerator(name = "SQ_AL_PRODUCTO", sequenceName = "SQ_AL_PRODUCTO", allocationSize = 1)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD_MEDIDA")
    private BigInteger idUnidadMedida;
    @Size(max = 2018)
    @Column(name = "CODIGO_QR")
    private String codigoQr;
    @Size(max = 2018)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MANEJA_LOTE")
    private Character manejaLote;
    @Size(max = 1024)
    @Column(name = "NOMBRE_LOTE")
    private String nombreLote;
    @Column(name = "GARANTIA")
    private BigInteger garantia;
    @Size(max = 2048)
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @Size(max = 2048)
    @Column(name = "IMAGEN")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INVENTARIO")
    private Character inventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO_FIJO")
    private Character activoFijo;
    @Column(name = "STOCK_MINIMO")
    private BigInteger stockMinimo;
    @Column(name = "STOCK_MAXIMO")
    private BigInteger stockMaximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPUESTO")
    private Character compuesto;
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
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AlGrupo idGrupo;
    @OneToMany(mappedBy = "productoPadre")
    private List<AlProducto> alProductoList;
    @JoinColumn(name = "PRODUCTO_PADRE", referencedColumnName = "ID")
    @ManyToOne
    private AlProducto productoPadre;
    @JoinColumn(name = "ID_CONVERSION_UNIDAD", referencedColumnName = "ID")
    @ManyToOne
    private PgConversionUnidad idConversionUnidad;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID")
    @ManyToOne
    private PgMarca idMarca;
    @JoinColumn(name = "ID_UBICACION_BODEGA", referencedColumnName = "ID")
    @ManyToOne
    private PgUbicacionBodega idUbicacionBodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<AlMovimientoDetalle> alMovimientoDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<AlOrdenCompraDetalle> alOrdenCompraDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<AlRequisicionDetalle> alRequisicionDetalleList;

    public AlProducto() {
    }

    public AlProducto(BigDecimal id) {
        this.id = id;
    }

    public AlProducto(BigDecimal id, String codigo, String nombre, BigInteger idUnidadMedida, Character manejaLote, Character inventario, Character activoFijo, Character compuesto, BigInteger empresa, short estadoRegistro, BigInteger usuarioCreacion, Date fechaCreacion) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.idUnidadMedida = idUnidadMedida;
        this.manejaLote = manejaLote;
        this.inventario = inventario;
        this.activoFijo = activoFijo;
        this.compuesto = compuesto;
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

    public BigInteger getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(BigInteger idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Character getManejaLote() {
        return manejaLote;
    }

    public void setManejaLote(Character manejaLote) {
        this.manejaLote = manejaLote;
    }

    public String getNombreLote() {
        return nombreLote;
    }

    public void setNombreLote(String nombreLote) {
        this.nombreLote = nombreLote;
    }

    public BigInteger getGarantia() {
        return garantia;
    }

    public void setGarantia(BigInteger garantia) {
        this.garantia = garantia;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Character getInventario() {
        return inventario;
    }

    public void setInventario(Character inventario) {
        this.inventario = inventario;
    }

    public Character getActivoFijo() {
        return activoFijo;
    }

    public void setActivoFijo(Character activoFijo) {
        this.activoFijo = activoFijo;
    }

    public BigInteger getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(BigInteger stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public BigInteger getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(BigInteger stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public Character getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(Character compuesto) {
        this.compuesto = compuesto;
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

    public AlGrupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(AlGrupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @XmlTransient
    public List<AlProducto> getAlProductoList() {
        return alProductoList;
    }

    public void setAlProductoList(List<AlProducto> alProductoList) {
        this.alProductoList = alProductoList;
    }

    public AlProducto getProductoPadre() {
        return productoPadre;
    }

    public void setProductoPadre(AlProducto productoPadre) {
        this.productoPadre = productoPadre;
    }

    public PgConversionUnidad getIdConversionUnidad() {
        return idConversionUnidad;
    }

    public void setIdConversionUnidad(PgConversionUnidad idConversionUnidad) {
        this.idConversionUnidad = idConversionUnidad;
    }

    public PgMarca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(PgMarca idMarca) {
        this.idMarca = idMarca;
    }

    public PgUbicacionBodega getIdUbicacionBodega() {
        return idUbicacionBodega;
    }

    public void setIdUbicacionBodega(PgUbicacionBodega idUbicacionBodega) {
        this.idUbicacionBodega = idUbicacionBodega;
    }

    @XmlTransient
    public List<AlMovimientoDetalle> getAlMovimientoDetalleList() {
        return alMovimientoDetalleList;
    }

    public void setAlMovimientoDetalleList(List<AlMovimientoDetalle> alMovimientoDetalleList) {
        this.alMovimientoDetalleList = alMovimientoDetalleList;
    }

    @XmlTransient
    public List<AlOrdenCompraDetalle> getAlOrdenCompraDetalleList() {
        return alOrdenCompraDetalleList;
    }

    public void setAlOrdenCompraDetalleList(List<AlOrdenCompraDetalle> alOrdenCompraDetalleList) {
        this.alOrdenCompraDetalleList = alOrdenCompraDetalleList;
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
        if (!(object instanceof AlProducto)) {
            return false;
        }
        AlProducto other = (AlProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.premium.almacen.entity.AlProducto[ id=" + id + " ]";
    }
    
}
