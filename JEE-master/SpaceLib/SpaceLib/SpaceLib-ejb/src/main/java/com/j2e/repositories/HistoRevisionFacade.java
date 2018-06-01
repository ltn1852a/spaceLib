/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoRevision;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maha-
 */
@Stateless
public class HistoRevisionFacade extends AbstractFacade<HistoRevision> implements HistoRevisionFacadeLocal {

    @PersistenceContext(unitName = "spaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoRevisionFacade() {
        super(HistoRevision.class);
    }
    
}
