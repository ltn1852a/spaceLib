/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoVoyage;
import com.j2e.entities.Reservation;
import com.j2e.entities.Voyage;
import java.util.ArrayList;
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
        cq.where(cb.equal(root.get("idUsager"), idUsager));
        List<Reservation> listReservation =getEntityManager().createQuery(cq).getResultList();
        
        //Récupérer les voyages
        List<Voyage> listVoyage=new ArrayList<Voyage>();
        for(Reservation r : listReservation){
            if(r.getVoyage()!=null){
                listVoyage.add(r.getVoyage());
            }
        }
        
        //Récupérer les histos
        List<HistoVoyage> listHisto=new ArrayList<HistoVoyage>();
        for(Voyage v : listVoyage){
            if(v!=null){
                listHisto.addAll(v.getHistoVoyage());
            }
        }
        
        //Créer une liste côté client
        List<com.j2e.business.HistoVoyage> listHistoClient=new ArrayList<com.j2e.business.HistoVoyage>();     
        for(HistoVoyage histo : listHisto){
            if(histo!=null){
                listHistoClient.add(new com.j2e.business.HistoVoyage(histo.getVoyage().getId(),histo.getTSext()));
            }
        }
        return listHistoClient;
    }
    
}
