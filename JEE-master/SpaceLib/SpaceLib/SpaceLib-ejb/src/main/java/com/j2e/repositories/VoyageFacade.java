/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoVoyage;
import com.j2e.entities.Reservation;
import com.j2e.entities.Voyage;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yannl
 */
@Stateless
public class VoyageFacade extends AbstractFacade<Voyage> implements VoyageFacadeLocal {

    @PersistenceContext(unitName = "spaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoyageFacade() {
        super(Voyage.class);
    }
    
    
}
