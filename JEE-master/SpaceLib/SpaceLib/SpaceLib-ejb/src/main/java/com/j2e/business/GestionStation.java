/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.HistoNavette;
import com.j2e.entities.Mecanicien;
import com.j2e.entities.Navette;
import com.j2e.entities.Station;
import com.j2e.exceptions.NavetteNotfoundException;
import com.j2e.exceptions.StationNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.repositories.HistoNavetteFacadeLocal;
import com.j2e.repositories.MecanicienFacadeLocal;
import com.j2e.repositories.NavetteFacadeLocal;
import com.j2e.repositories.StationFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ben
 */
@Stateless
public class GestionStation implements GestionStationLocal {


    @EJB
    private MecanicienFacadeLocal mecaFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;
    
    @EJB
    private HistoNavetteFacadeLocal histoNavFacade;
        
    @EJB
    private StationFacadeLocal stationFacade;    

    @Override
    public void consulterListeNavetteAReviser(Long idMecanicien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void renseignerStationRattachement(Long idMecanicien, Long idStation)throws userNotFoundException, StationNotFoundException{
        //find mecanicien as a user
        Mecanicien m = mecaFacade.find(idMecanicien);
        if (m!=null){
            //chercher sa station de rattachement
            Station s = m.getStation();
            
            //vérifier que sa station existe
            Station s1 = stationFacade.find(s.getId());
            
            if(s1== null){
                throw new StationNotFoundException("Station de ratachement n existe pas");
            }
        }else{
            throw new userNotFoundException("Mecanicien introuvable");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void annoncerDebutRevision(Long idNavette) throws NavetteNotfoundException {
        //vérifier si la navette existe
        Navette n = navetteFacade.find(idNavette);
        if(n==null){
            throw new NavetteNotfoundException("Navette introuvable");
        }else{
            n.setDisponible(false);
            //ajouter historique navette
            HistoNavette hn = new HistoNavette(n, "Debut revision navette numéro "+n.getId().toString());
            histoNavFacade.create(hn);
        }
    }

    @Override
    public void annoncerFinRevision(Long idNavette) throws NavetteNotfoundException {        
       //vérifier si la navette existe
        Navette n = navetteFacade.find(idNavette);
        if(n==null){
            throw new NavetteNotfoundException("Navette introuvable");
        }else{
            n.setDisponible(true);
            //ajouter historique navette
            HistoNavette hn = new HistoNavette(n, "Fin revision navette numéro "+n.getId().toString());
        }
    }
}
