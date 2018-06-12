/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;

import com.j2e.business.GestionStationLocal;
import com.j2e.exceptions.NavetteNotfoundException;
import com.j2e.exceptions.StationNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author maha-
 */
@Stateless
public class ServicesMecanicien implements ServicesMecanicienLocal {

    @EJB
    private GestionStationLocal gstation;
      
    @Override
    public void renseignerStationRattachement(Long idMecanicien, Long idStation) throws userNotFoundException, StationNotFoundException {
        gstation.renseignerStationRattachement(idMecanicien, idStation);
    }

    @Override
    public void annoncerDebutRevision(Long idNavette) throws NavetteNotfoundException {
        gstation.annoncerDebutRevision(idNavette);
    }

    @Override
    public void annoncerFinRevision(Long idNavette) throws NavetteNotfoundException {
        gstation.annoncerFinRevision(idNavette);
        
    }


}
