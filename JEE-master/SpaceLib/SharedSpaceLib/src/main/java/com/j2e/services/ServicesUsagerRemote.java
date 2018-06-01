/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;


import com.j2e.exceptions.VoyageAlreadyFinishedException;
import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author maha-
 */
@Remote
public interface ServicesUsagerRemote {
    public void identifierUsager(String pseudo, String mdp);
    public void créerCompte(String pseudo, String mdp) throws userNotFoundException, PwdIncorrectException;
    public void réserverVoyage(Long idUsager,int nbVoyage, Long stationDepart, Long stationArriv)throws VoyageNotFoundException;
    public void finaliserVoyage(Long idVoyage) throws VoyageNotFoundException, VoyageAlreadyFinishedException;
    public List<com.j2e.business.HistoVoyage> consulterHistVoyage(Long idVoyage) throws VoyageNotFoundException;
   
}
