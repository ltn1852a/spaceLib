/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.Navette;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yannl
 */
@Stateless
public class NavetteFacade extends AbstractFacade<Navette> implements NavetteFacadeLocal {

    @PersistenceContext(unitName = "spaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NavetteFacade() {
        super(Navette.class);
    }

    @Override
    public Navette findNavetteDispo(int nbVoyagers, int idStation) {
        List<Navette> listNavettes = this.findAll();
        List<Navette> listNavettesDispo = new ArrayList<Navette>();
        Iterator<Navette> listNavettesIterator = listNavettes.iterator();
        while (listNavettesIterator.hasNext()) {
            Navette n = listNavettesIterator.next();
            if (n.getQuai().getStation().getId() == idStation && n.getNbPLaces() >= nbVoyagers && n.getNbVoyages() < 3){
                return n;
            }
        }
        return null;
    }
    
    @Override
    public List<Navette> findNavetteAReviser(int idStation) {
        List<Navette> listNavettes = this.findAll();
        List<Navette> listNavettesAReviser = new ArrayList<Navette>();
        Iterator<Navette> listNavettesIterator = listNavettes.iterator();
        while (listNavettesIterator.hasNext()) {
            Navette n = listNavettesIterator.next();
            if (n.getQuai().getStation().getId() == idStation && n.getNbVoyages() == 3){
                listNavettesAReviser.add(n);
            }
        }
        return listNavettesAReviser;
    }
    
}
