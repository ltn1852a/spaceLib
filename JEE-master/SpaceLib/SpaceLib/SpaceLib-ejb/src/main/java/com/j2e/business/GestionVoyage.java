/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;



import com.j2e.entities.Usager;


import com.j2e.entities.Voyage;
import com.j2e.entities.Voyage.Etat;
import com.j2e.repositories.VoyageFacade;
import com.j2e.repositories.VoyageFacadeLocal;

import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageAlreadyFinishedException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.repositories.UsagerFacadeLocal;
import com.j2e.repositories.HistoVoyageFacadeLocal;
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
    private HistoVoyageFacadeLocal histoFacade;
            

    @Override
    public void réserverVoyage(int idUsaager, int nbVoyages, int idStationDepart, int idstationArriv) {
       //Voyage v  = new Voyage(idUsaager, nbVoyages,  idStationDepart,  idstationArriv);
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
