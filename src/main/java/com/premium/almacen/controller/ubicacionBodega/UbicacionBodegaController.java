/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.controller.ubicacionBodega;

import com.premium.almacen.ejb.PgUbicacionBodegaFacade;
import com.premium.almacen.entity.PgUbicacionBodega;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

/**
 *
 * @author 57311
 */
@Named(value = "ubicacionBodegaController")
@ViewScoped
public class UbicacionBodegaController implements Serializable {

    /**
     * Creates a new instance of UbicacionBodegaController
     */
    @EJB
    private PgUbicacionBodegaFacade ubicacionBodegaFacade;
    
    private PgUbicacionBodega ubicacionBodega;
    
    public UbicacionBodegaController() {
        this.ubicacionBodega = new PgUbicacionBodega();
    }

    public PgUbicacionBodega getUbicacionBodega() {
        return ubicacionBodega;
    }

    public void setUbicacionBodega(PgUbicacionBodega ubicacionBodega) {
        this.ubicacionBodega = ubicacionBodega;
    }
    
    public List<PgUbicacionBodega> listarUbicacionBodega(){
        return this.ubicacionBodegaFacade.findAll();
    }
    
     public String iniciarEditarUbicacionBodega(PgUbicacionBodega pgUbicacionBodega){
        this.ubicacionBodega = pgUbicacionBodega;
        return "editar";
    }
    
    public String editar(){
        this.ubicacionBodegaFacade.edit(this.ubicacionBodega);
        this.ubicacionBodega = new PgUbicacionBodega();
        return "listar";
    }
    
    public String iniciarCrearUbicacionBodega(){
        this.ubicacionBodega = new PgUbicacionBodega();
        java.util.Date fecha = new Date();
        ubicacionBodega.setFechaCreacion(fecha);
        ubicacionBodega.setFechaModificacion(fecha);
        return "crear";
    }
    public String crearUbicacionBodega(){
        ubicacionBodegaFacade.create(ubicacionBodega);
        this.ubicacionBodega= new PgUbicacionBodega();
        return "listar";
    }
    
    public String eliminarUbicacionBodega(PgUbicacionBodega pgUbicacionBodega){
        this.ubicacionBodegaFacade.remove(pgUbicacionBodega);
        return "listar";
    }
    
}
