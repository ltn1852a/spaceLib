/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;



import com.j2e.business.GestionSpaceLibLocal;
import com.j2e.business.GestionVoyageLocal;
import com.j2e.entities.Station;

import com.j2e.exceptions.VoyageAlreadyFinishedException;

import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.navettesNotAvailableException;
import com.j2e.exceptions.quaisNotAvailableException;
import com.j2e.exceptions.reservationNotFoundException;
import com.j2e.exceptions.userAlreadyExistsException;
import com.j2e.exceptions.userNotFoundException;
import java.util.ArrayList;
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
    private GestionSpaceLibLocal gestionSpaceLib;
    
    @EJB
    private GestionVoyageLocal gestionVoyage;    
 

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
    public void créerCompte(String pseudo, String mdp) throws userAlreadyExistsException {
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



    @Override
    public void réserverVoyage(Long idUsager, int nbVoyage, Long stationDepart, Long stationArriv) throws navettesNotAvailableException, quaisNotAvailableException {
        this.gestionVoyage.réserverVoyage(idUsager, nbVoyage, stationDepart, stationArriv);
    }

    @Override
    public List<String> consulterListeStation() {
        List<Station> stats= this.gestionSpaceLib.getSataions();
        List<String> listStation=new ArrayList<>();
        if(stats.size()>0){
            for(int i=0; i<stats.size() ;i++){
                listStation.add(stats.get(i).toString());
            }
        }
        return listStation;
    }

    @Override
    public void cloturerRéservation(Long idResa) throws reservationNotFoundException {
        gestionVoyage.cloturerRéservation(idResa);
    }


}
