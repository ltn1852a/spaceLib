/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoVoyage;
import com.j2e.entities.Reservation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    @Override
   public List<com.j2e.business.HistoVoyage> findByUsager(Long idUsager){
        //Récuperer les reservations
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
        Root<Reservation> root = cq.from(Reservation.class);
        //cq.where(cb.equal(root.get("usager.get"), client));
      //  return getEntityManager().createQuery(cq).getResultList(); 
        
       // CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
       // CriteriaQuery<HistoVoyage> cq = cb.createQuery(HistoVoyage.class);
       // Root<HistoVoyage> root = cq.from(HistoVoyage.class);
      //  cq.where(cb.equal(root.get("client"), client));
      //  return getEntityManager().createQuery(cq).getResultList(); 
      return null;
    }
    
}
