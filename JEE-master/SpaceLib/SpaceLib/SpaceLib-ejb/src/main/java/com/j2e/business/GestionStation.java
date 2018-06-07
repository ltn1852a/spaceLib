/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.Mecanicien;
import com.j2e.exceptions.StationNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.repositories.MecanicienFacadeLocal;
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

    
    @Override
    public void consulterListeNavetteAReviser(Integer idMecanicien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void renseignerStationRattachement(Long idMecanicien, Long idStation)throws userNotFoundException, StationNotFoundException{
        //find mecanicien as a user
        Mecanicien m = mecaFacade.find(idMecanicien);
        if (m!=null){
            //chercher sa station de rattachement
            //Station s = m.getStation();
        }else{
            throw new userNotFoundException("Mecanicien introuvable");
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
