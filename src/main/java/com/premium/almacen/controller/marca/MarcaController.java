/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.controller.marca;


import com.premium.almacen.ejb.PgMarcaFacade;
import com.premium.almacen.entity.PgMarca;
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
@Named(value = "marcaController")
@ViewScoped
public class MarcaController implements Serializable {

    /**
     * Creates a new instance of MarcaController
     */
    public MarcaController() {
        this.marca = new PgMarca();
    }
    
   
    
    @EJB
    private PgMarcaFacade marcaFacade;
    
    private PgMarca marca;


    public PgMarca getMarca() {
        return marca;
    }

    public void setMarca(PgMarca marca) {
        this.marca = marca;
    }
    
     
    public List<PgMarca> listarMarca(){
        return this.marcaFacade.findAll();
    }
    
    public String iniciarEditarMarca(PgMarca pgMarca){
        this.marca = pgMarca;
        return "editar";
    }
    
    public String editar(){
        this.marcaFacade.edit(this.marca);
        this.marca = new PgMarca();
        return "listar";
    }
    
    public String iniciarCrearMarca(){
        this.marca = new PgMarca();
        java.util.Date fecha = new Date();
        marca.setFechaCreacion(fecha);
        marca.setFechaModificacion(fecha);
        return "crear";
    }
    public String crearMarca(){
        
        
        marcaFacade.create(marca);
        this.marca= new PgMarca();
        return "listar";
    }
    
    public String eliminarMarca(PgMarca pgMarca){
        this.marcaFacade.remove(pgMarca);
        return "listar";
    }
    
    
}
