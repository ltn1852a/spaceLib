/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author maha-
 */
@Remote
public interface GestionVoyageRemote {
   public void réserverVoyage(int idUsaager, int nbVoyages, int idStationDepart, int idstationArriv );
   public List<Integer> consulterHistoVoyage(int idUsager);
    
}
