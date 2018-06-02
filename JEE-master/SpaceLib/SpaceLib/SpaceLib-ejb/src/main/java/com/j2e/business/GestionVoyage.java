/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;



import com.j2e.entities.Navette;
import com.j2e.entities.Quai;
import com.j2e.entities.Station;
import com.j2e.entities.Usager;


import com.j2e.entities.Voyage;
import com.j2e.entities.Voyage.Etat;
import com.j2e.repositories.VoyageFacade;
import com.j2e.repositories.VoyageFacadeLocal;

import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageAlreadyFinishedException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.navettesNotAvailableException;
import com.j2e.exceptions.quaisNotAvailableException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.repositories.UsagerFacadeLocal;
import com.j2e.repositories.HistoVoyageFacadeLocal;
import com.j2e.repositories.QuaiFacadeLocal;
import com.j2e.repositories.StationFacadeLocal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private UsagerFacadeLocal usagerFacade;

    
    @EJB
    private VoyageFacadeLocal voyageFacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    
    @EJB
    private StationFacadeLocal stationFacade;
    
    @EJB
    private HistoVoyageFacadeLocal histoFacade;
            

    @Override
    public void réserverVoyage(int idUsager, int nbVoyageurs, int idStationDepart, int idStationArriv) throws navettesNotAvailableException,quaisNotAvailableException{
        
        //chercher une navette dispo ayant des places >= au nbVoyagers demandé
        
        Usager u = usagerFacade.find(idUsager);
        Station sDepart= stationFacade.find(idStationDepart);
        Station sArriv= stationFacade.find(idStationArriv); 
        
        Navette nav = getNavetteDispoOnStation(sDepart, nbVoyageurs) ;
        if(nav != null){
            //look for quai dispo in destination Station
            Quai q = getQuaiDispoInDestination(sArriv);
            if(q ==null){
                throw new quaisNotAvailableException("Pas de quai disponible à la destination choisie");
            }else{
                //tout s est bien déroulé
                  SimpleDateFormat dateDepart = new SimpleDateFormat("dd/MM/yyyy");
                Calendar c = Calendar.getInstance();
                c.setTime(new Date()); 
                c.add(Calendar.DATE, Station.tempsTrajet(sDepart,sArriv)); 
                  Date dateArrivee =c.getTime();
                  Voyage v  = new Voyage( nbVoyageurs, dateDepart,dateArrivee,  nav,sDepart, sArriv);
                   
                   
                    voyageFacade.create(v);
                    
                    //rendre le quai de depart indisponible 
                    nav.getQuai().setNavette(nav);
                     quaiFacade.edit(nav.getQuai());
            }
        }else{
            throw new navettesNotAvailableException();
        }   

    }

    
        public Navette getNavetteDispoOnStation(Station station, int nbVoyagers) {
        //get list quai
        List<Quai> quais = station.getQuais();
        Navette nav = null;        
        
        //find occupied quais
        if (quais != null) {
            for (int i = 0; i < quais.size(); i++) {
                    nav = quais.get(i).getNavette();
                   if(nav !=null){
                        //check if navetteon quai is dispo
                       if(nav.isDisponible() && nav.getNbPLaces()>= nbVoyagers){
                           return nav;
                       }
                   }
            }
        }
        
        return nav;
    }
    
        
    public Quai getQuaiDispoInDestination(Station sDest){
        List<Quai> quais = sDest.getQuais();
        if(quais!=null){
            for (int i = 0; i < quais.size(); i++) {
                if(quais.get(i).getNavette() == null){
                    //donc il est dispo
                    return quais.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public void finaliserVoyage(Long idVoyage)throws VoyageNotFoundException, VoyageAlreadyFinishedException{
        //Récupération du bon voyage 
        final Voyage v =this.voyageFacade.find(idVoyage);
        
        //Verification si voyage n'existe pas ou déjà finalisé 
        if(v==null){
            throw new VoyageNotFoundException();
        }
        if(v.getEtat()==Etat.Finalisé){
            throw new VoyageAlreadyFinishedException();
        }
        //Changement d'etat et update bdd
        v.setEtat(Etat.Finalisé);
        this.voyageFacade.edit(v);
    }


    @Override
    public List<com.j2e.business.HistoVoyage> consulterHistoVoyage(Long idUsager) {
      final List<com.j2e.business.HistoVoyage> histo;
        histo = this.histoFacade.findByUsager(idUsager);
       return null;
    }

    @Override
    public Long identifierUsager(String pseudo, String mdp) throws userNotFoundException, PwdIncorrectException {

        Usager u = usagerFacade.finByPseudo(pseudo);
        if (u.equals(null)) {
            throw new userNotFoundException("User not found");
        } else {
            u = usagerFacade.finByPseudoAndMdp(pseudo, mdp);
            if (u == null) {
                throw new PwdIncorrectException();
            } else {
                return u.getId();
            }
        }

    }

    @Override
    public void créerCompte(String pseudo, String mdp) throws userNotFoundException, PwdIncorrectException {
        Usager u = usagerFacade.finByPseudo(pseudo);
        if (u == null) {
            throw new userNotFoundException("User not found");
        } else {
            usagerFacade.créerCompteUsager(pseudo, mdp);
        }
    }
}
