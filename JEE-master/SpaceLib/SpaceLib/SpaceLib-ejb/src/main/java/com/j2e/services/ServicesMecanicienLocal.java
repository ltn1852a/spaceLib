/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;

import com.j2e.exceptions.NavetteNotfoundException;
import com.j2e.exceptions.StationNotFoundException;
import com.j2e.exceptions.userNotFoundException;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface ServicesMecanicienLocal {
    public void renseignerStationRattachement(Long idMecanicien, Long idStation)throws userNotFoundException, StationNotFoundException;
    public void annoncerDebutRevision(Long idNavette) throws NavetteNotfoundException;
    public void annoncerFinRevision(Long idNavette) throws NavetteNotfoundException;
}
