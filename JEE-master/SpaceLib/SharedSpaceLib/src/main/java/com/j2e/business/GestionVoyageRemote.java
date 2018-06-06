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
import com.j2e.exceptions.userAlreadyExistsException;
import com.j2e.exceptions.userNotFoundException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author maha-
 */
@Remote
public interface GestionVoyageRemote {
   public void réserverVoyage(int idUsaager, int nbVoyages, int idStationDepart, int idstationArriv )throws navettesNotAvailableException, quaisNotAvailableException;

   public Long identifierUsager(String pseudo, String mdp)throws userNotFoundException, PwdIncorrectException;
   public void créerCompte(String pseudo, String mdp) throws userAlreadyExistsException;
   public List<HistoVoyage> consulterHistoVoyage(Long idUsager);
   public void finaliserVoyage(Long idVoyage)throws VoyageNotFoundException, VoyageAlreadyFinishedException;
}
