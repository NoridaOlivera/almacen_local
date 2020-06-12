/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.controller.producto;

import com.premium.almacen.ejb.AlProductoFacade;
import com.premium.almacen.ejb.PgBodegaFacade;
import com.premium.almacen.entity.AlProducto;
import com.premium.almacen.entity.PgBodega;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author 57311
 */
@Named(value = "productoController")
@ViewScoped
public class ProductoController implements Serializable {

     @EJB
    private AlProductoFacade productoFacade;
    
    private AlProducto producto;

    public AlProducto getProducto() {
        return producto;
    }

    public void setProducto(AlProducto producto) {
        this.producto = producto;
    }
    
    
    public ProductoController() {
        this.producto = new AlProducto();
    }
    
    public List<AlProducto> listarProducto(){
        return this.productoFacade.findAll();
    }
    
    public String iniciarEditarProducto(AlProducto alProducto){
        this.producto = alProducto;
        return "editar";
    }
    
    public String Editar(){
        this.productoFacade.edit(this.producto);
        this.producto = new AlProducto();
        return "listar";
    }
    
    public String iniciarCrearProducto(){
        this.producto = new AlProducto();
        java.util.Date fecha = new Date();
        producto.setFechaCreacion(fecha);
       // producto.setEstadoRegistro(short(0));
       
      //  producto.setFechaModificacion(fecha);
        return "crear";
    }
    
     public String crearProducto(){
       productoFacade.create(producto);
        this.producto = new AlProducto();
        return "listar";
    }
     
    public String eliminarProducto(AlProducto alProducto){
        this.productoFacade.remove(alProducto);
        return "listar";
    }
    
}
