/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.exceptions.NavetteNotfoundException;
import com.j2e.exceptions.StationNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import javax.ejb.Local;

/**
 *
 * @author ben
 */
@Local
public interface GestionStationLocal {
    
    // TODO
    // fournis la liste des navette à reviser selon l'idmecanicien fournis (sa station de rattachement) 
    public void consulterListeNavetteAReviser(Long idMecanicien);
    // verif que idstation corespond bien à la station de rattachement du mecaniscien correspondant à l'id fournis
    public void renseignerStationRattachement(Long idMecanicien, Long idStation)throws userNotFoundException, StationNotFoundException;
    //annonce le debut de revision de la navette correspondante à l'idNavette fournis
    public void annoncerDebutRevision(Long idNavette) throws NavetteNotfoundException;
    //annonce la fin de revision de la navette correspondante à l'idNavette fournis
    public void annoncerFinRevision(Long idNavette) throws NavetteNotfoundException;
    
}
