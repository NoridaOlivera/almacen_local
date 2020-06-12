/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.controller.bodega;

import com.premium.almacen.ejb.PgBodegaFacade;
import com.premium.almacen.entity.PgBodega;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author 57311
 */
@Named(value = "bodegaController")
@ViewScoped
public class BodegaController implements Serializable {

    /**
     * Creates a new instance of BodegaController
     */
    
    
    @EJB
    private PgBodegaFacade bodegaFacade;
    
    private PgBodega bodega;
    
    public PgBodega getBodega() {
        return bodega;
    }

    public void setBodega(PgBodega bodega) {
        this.bodega = bodega;
    }
    
    
    public BodegaController() {
        this.bodega = new PgBodega();
    }

    
       
    public List<PgBodega> listarBodegas(){
        return this.bodegaFacade.findAll();
    }
    
    public String IniciarEditarBodega(PgBodega pgBodega){
        this.bodega = pgBodega;
        return "editar";
    }
    
    public String Editar(){
        this.bodegaFacade.edit(this.bodega);
        this.bodega = new PgBodega();
        return "listar";
    }
    
    public String iniciarCrearBodega(){
        this.bodega = new PgBodega();
        java.util.Date fecha = new Date();
        bodega.setFechaCreacion(fecha);
        bodega.setFechaModificacion(fecha);
        return "crear";
    }
    
    public String crearBodega(){
       bodegaFacade.create(bodega);
        this.bodega = new PgBodega();
        return "listar";
    }
    
    public String eliminarBodega(PgBodega pgBodega){
        this.bodegaFacade.remove(pgBodega);
        return "listar";
    }
    
    
    
}
