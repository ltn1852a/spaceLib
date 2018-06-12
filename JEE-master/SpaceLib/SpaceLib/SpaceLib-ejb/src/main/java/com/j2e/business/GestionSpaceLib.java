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

    @Override
    public void créerStation(List<Integer> nbPlaces, String loc) {
        Station s = new Station(new ArrayList<Quai>(),new ArrayList<Mecanicien>(),loc);
        stationFacade.create(s);
        Iterator<Integer> nbPlacesIterator = nbPlaces.iterator();
        while (nbPlacesIterator.hasNext()) {
            Integer nbPlace = nbPlacesIterator.next();
            Navette n = new Navette(nbPlace);
            navetteFacade.create(n);
            Quai q1 = new Quai(s);
            quaiFacade.create(q1);
            q1.setNavette(n);
            quaiFacade.edit(q1);
            n.setQuai(q1);
            navetteFacade.edit(n);
            Quai q2 = new Quai(s);
            quaiFacade.create(q2);
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
