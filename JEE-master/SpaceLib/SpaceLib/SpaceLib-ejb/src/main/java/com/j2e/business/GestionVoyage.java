/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.HistoVoyage;
import com.j2e.entities.Usager;
import com.j2e.entities.Voyage;
import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.repositories.UsagerFacadeLocal;
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

    @Override
    public void réserverVoyage(int idUsaager, int nbVoyages, int idStationDepart, int idstationArriv) {
       //Voyage v  = new Voyage(idUsaager, nbVoyages,  idStationDepart,  idstationArriv);
    }

    @Override
    public List<Integer> consulterHistoVoyage(int idUsager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
