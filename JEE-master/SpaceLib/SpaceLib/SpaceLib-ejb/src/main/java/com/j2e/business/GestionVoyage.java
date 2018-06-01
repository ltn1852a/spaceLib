/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.HistoVoyage;
import com.j2e.repositories.VoyageFacade;
import com.j2e.repositories.VoyageFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author maha-
 */
@Stateless
public class GestionVoyage implements GestionVoyageRemote {
    
    @EJB
    private VoyageFacadeLocal voyageFacade;
    
    @EJB
    private Histo
    @Override
    public void réserverVoyage(int idUsaager, int nbVoyages, int idStationDepart, int idstationArriv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void finaliserVoyage(int idVoyage){
        
    }

    @Override
    public List<Integer> consulterHistoVoyage(int idUsager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
