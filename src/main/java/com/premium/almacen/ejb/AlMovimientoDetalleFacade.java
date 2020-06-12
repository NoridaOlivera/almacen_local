/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.ejb;

import com.premium.almacen.entity.AlMovimientoDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 57311
 */
@Stateless
public class AlMovimientoDetalleFacade extends AbstractFacade<AlMovimientoDetalle> {

    @PersistenceContext(unitName = "AlmacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlMovimientoDetalleFacade() {
        super(AlMovimientoDetalle.class);
    }
    
}
