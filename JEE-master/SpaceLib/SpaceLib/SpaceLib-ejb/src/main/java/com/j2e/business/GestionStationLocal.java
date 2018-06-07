/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import javax.ejb.Local;

/**
 *
 * @author ben
 */
@Local
public interface GestionStationLocal {
    
    public void consulterListeNavetteAReviser(Integer idMecanicien);
    
}
