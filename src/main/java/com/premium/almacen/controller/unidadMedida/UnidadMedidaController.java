/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.controller.unidadMedida;


import com.premium.almacen.ejb.PgUnidadMedidaFacade;
import com.premium.almacen.entity.PgUnidadMedida;
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
@Named(value = "unidadMedidaController")
@ViewScoped
public class UnidadMedidaController implements Serializable {

    /**
     * Creates a new instance of UnidadMedidaController
     */
    public UnidadMedidaController() {
        this.unidadMedida= new PgUnidadMedida();
    }
    
    @EJB
    private PgUnidadMedidaFacade unidadMedidaFacade;
    
    private PgUnidadMedida unidadMedida;

    public PgUnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(PgUnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<PgUnidadMedida> listarUnidadMedida(){
        return this.unidadMedidaFacade.findAll();
    }
     
     
    
    public String iniciarEditarUnidadMedida(PgUnidadMedida pgUnidadMedida){
        this.unidadMedida = pgUnidadMedida;
        return "editar";
    }
    
    public String editar(){
        this.unidadMedidaFacade.edit(this.unidadMedida);
        this.unidadMedida = new PgUnidadMedida();
        return "listar";
    }
    
    public String iniciarCrearUnidadMedida(){
        this.unidadMedida = new PgUnidadMedida();
        java.util.Date fecha = new Date();
        unidadMedida.setFechaCreacion(fecha);
        unidadMedida.setFechaModificacion(fecha);
        return "crear";
    }
    public String crearUnidadMedida(){
        unidadMedidaFacade.create(unidadMedida);
        this.unidadMedida= new PgUnidadMedida();
        return "listar";
    }
    
    public String eliminarUnidadMedida(PgUnidadMedida pgUnidadMedida){
        this.unidadMedidaFacade.remove(pgUnidadMedida);
        return "listar";
    }
    
    
}
