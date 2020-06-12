/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premium.almacen.ejb;

import com.premium.almacen.entity.PgConsecutivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 57311
 */
@Stateless
public class PgConsecutivoFacade extends AbstractFacade<PgConsecutivo> {

    @PersistenceContext(unitName = "AlmacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PgConsecutivoFacade() {
        super(PgConsecutivo.class);
    }
    
}
