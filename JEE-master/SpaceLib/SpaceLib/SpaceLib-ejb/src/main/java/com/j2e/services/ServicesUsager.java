/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;

import com.j2e.business.GestionSpaceLibRemote;
import com.j2e.business.GestionVoyageRemote;
import com.j2e.exceptions.VoyageAllreadyFinishedException;
import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author maha-
 */
@Stateless
public class ServicesUsager implements ServicesUsagerRemote {
    
    @EJB
    private GestionSpaceLibRemote gestionSpaceLib;
    
    @EJB
    private GestionVoyageRemote gestionVoyage;
    
    @Override
    public void identifierUsager(String pseudo, String mdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void créerCompte(String pseudo, String mdp) throws userNotFoundException, PwdIncorrectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finaliserVoyage(int idVoyage) throws VoyageNotFoundException, VoyageAllreadyFinishedException {
      this.gestionVoyage.finaliserVoyage(idVoyage);
    }

    @Override
    public List<Integer> consulterHistVoyage(int idVoyage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void réserverVoyage(int idVoyage) throws VoyageNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
