/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.exceptions.StationNotFoundException;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author maha-
 */
@Stateless
public class GestionSpaceLib implements GestionSpaceLibRemote {

    @Override
    public void créerStation(Map<Integer, Integer> quais, Localisation loc) {
        
    }

    @Override
    public void créerNavette(int nbPlaces, int idStation) throws StationNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void créerQuai(int idStation) throws StationNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
