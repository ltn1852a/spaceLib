/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.Mecanicien;
import com.j2e.entities.Quai;
import com.j2e.entities.Navette;

import com.j2e.entities.Station;
import com.j2e.repositories.NavetteFacadeLocal;
import com.j2e.repositories.QuaiFacadeLocal;
import com.j2e.repositories.StationFacadeLocal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author maha-
 */
@Stateless
public class GestionSpaceLib implements GestionSpaceLibLocal {

        @EJB
    private StationFacadeLocal stationFacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;

    // cree une station pour la location location fournis
    // la list represente les nombres de places de chaque navette
    // le nombre de navette est créé
    // le nombre de quai créé représente le double du nombre de navette
    // les navettes sont affectés aux quais affectés à la station
    @Override
    public void créerStation(List<Integer> nbPlaces, String loc) {
        // cree la station
        Station s = new Station(loc);
        stationFacade.create(s);
        // pour chaque nb place de navette renseigné
        Iterator<Integer> nbPlacesIterator = nbPlaces.iterator();
        while (nbPlacesIterator.hasNext()) {
            //creation de navette
            Integer nbPlace = nbPlacesIterator.next();
            Navette n = new Navette(nbPlace);
            navetteFacade.create(n);
            // creation quai et affectation navette/quai
            Quai q1 = new Quai(s);
            quaiFacade.create(q1);
            q1.setNavette(n);
            quaiFacade.edit(q1);
            n.setQuai(q1);
            navetteFacade.edit(n);
            // creation quai sup 
            Quai q2 = new Quai(s);
            quaiFacade.create(q2);
            // affectation quai/station
            s.addQuai(q1);
            stationFacade.edit(s);
            s.addQuai(q2);
            stationFacade.edit(s);
        }

        
        
    }

    @Override
    public List<Station> getSataions() {
        return stationFacade.findAll();
    }
}
