/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoVoyage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maha-
 */
@Stateless
public class HistoVoyageFacade extends AbstractFacade<HistoVoyage> implements HistoVoyageFacadeLocal {

    @PersistenceContext(unitName = "spaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoVoyageFacade() {
        super(HistoVoyage.class);
    }
    
}
