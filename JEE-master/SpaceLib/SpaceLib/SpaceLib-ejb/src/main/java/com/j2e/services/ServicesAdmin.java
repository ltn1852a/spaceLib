/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;

import com.j2e.business.GestionSpaceLib;
import com.j2e.business.GestionSpaceLibRemote;
import com.j2e.business.Localisation;
import com.j2e.exceptions.StationNotFoundException;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author maha-
 */
@Stateless
public class ServicesAdmin implements ServicesAdminRemote {

  @EJB
    private GestionSpaceLibRemote gSpaceLib;
  
    @Override
    public void créerStation(Map<Integer, Integer> quais, Localisation loc) {
        gSpaceLib.créerStation(quais, loc);
    }

    @Override
    public void créerNavette(int nbPlaces, int idStation) throws StationNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void créerQuai(int idStation) throws StationNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
