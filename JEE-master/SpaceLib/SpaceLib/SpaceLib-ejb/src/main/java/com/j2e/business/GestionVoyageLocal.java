/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;
import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageAlreadyFinishedException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.navettesNotAvailableException;
import com.j2e.exceptions.quaisNotAvailableException;
import com.j2e.exceptions.reservationNotFoundException;
import com.j2e.exceptions.userAlreadyExistsException;
import com.j2e.exceptions.userNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface GestionVoyageLocal {
     public void réserverVoyage(Long idUsaager, int nbVoyages, Long idStationDepart, Long idstationArriv )throws navettesNotAvailableException, quaisNotAvailableException;

   public Long identifierUsager(String pseudo, String mdp)throws userNotFoundException, PwdIncorrectException;
   public void créerCompte(String pseudo, String mdp) throws userAlreadyExistsException;
   public List<HistoVoyage> consulterHistoVoyage(Long idUsager);
   public void finaliserVoyage(Long idVoyage)throws VoyageNotFoundException, VoyageAlreadyFinishedException;
   public void cloturerRéservation(Long idResa) throws reservationNotFoundException;
   

}
