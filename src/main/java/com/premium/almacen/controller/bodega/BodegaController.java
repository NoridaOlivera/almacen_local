/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.controller.bodega;

import com.premium.almacen.ejb.PgBodegaFacade;
import com.premium.almacen.entity.PgBodega;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author 57311
 */
@Named(value = "bodegaController")
@SessionScoped
public class BodegaController implements Serializable {

    /**
     * Creates a new instance of BodegaController
     */
    public BodegaController() {
    }
    
    @EJB
    private PgBodegaFacade bodegaFacade;
    
    private PgBodega bodega;

    public PgBodega getBodega() {
        return bodega;
    }

    public void setBodega(PgBodega bodega) {
        this.bodega = bodega;
    }
    
    
    
    
    public List<PgBodega> listarBodegas(){
        return this.bodegaFacade.findAll();
    }
    
    public String IniciarEditarBodega(PgBodega pgBodega){
        this.bodega = pgBodega;
        return "editar";
    }
    
    public String Editar(){
        this.bodegaFacade.edit(bodega);
        this.bodega = new PgBodega();
        return "listar";
    }
    
    public String IniciarCrearBodega(){
        this.bodegaFacade.create(bodega);
        bodega = new PgBodega();
        return ("crear");
    }
    public String CrearBodega(){
        this.bodegaFacade.create(bodega);
        this.bodega = new PgBodega();
        return "listar";
    }
    
    
    
}
