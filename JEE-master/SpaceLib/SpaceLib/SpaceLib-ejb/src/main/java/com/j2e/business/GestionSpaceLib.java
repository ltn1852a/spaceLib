/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.Station;
import com.j2e.exceptions.StationNotFoundException;
import com.j2e.repositories.StationFacade;
import com.j2e.repositories.StationFacadeLocal;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author maha-
 */
@Stateless
public class GestionSpaceLib implements GestionSpaceLibRemote {

    @EJB
    private StationFacadeLocal stationFacade;

    @Override
    public void créerStation(List<Integer> nbPlaces, Localisation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
