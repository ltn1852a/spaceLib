/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;



import com.j2e.business.GestionSpaceLibRemote;
import com.j2e.business.GestionVoyageRemote;

import com.j2e.exceptions.VoyageAlreadyFinishedException;

import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      try {
          gestionVoyage.identifierUsager(pseudo, mdp);
      } catch (userNotFoundException ex) {
          Logger.getLogger(ServicesUsager.class.getName()).log(Level.SEVERE, null, ex);
      } catch (PwdIncorrectException ex) {
          Logger.getLogger(ServicesUsager.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public void créerCompte(String pseudo, String mdp) throws userNotFoundException, PwdIncorrectException {
        gestionVoyage.créerCompte(pseudo, mdp);
    }

    @Override
    public void finaliserVoyage(Long idVoyage) throws VoyageNotFoundException, VoyageAlreadyFinishedException {
      this.gestionVoyage.finaliserVoyage(idVoyage);
    }

    @Override
    public List<com.j2e.business.HistoVoyage> consulterHistVoyage(Long idVoyage) {
      return this.gestionVoyage.consulterHistoVoyage(idVoyage);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void réserverVoyage(Long idUsager,int nbVoyage, Long stationDepart, Long stationArriv)throws VoyageNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
