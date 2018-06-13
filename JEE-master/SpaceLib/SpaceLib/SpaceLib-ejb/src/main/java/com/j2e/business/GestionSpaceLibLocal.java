/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

import com.j2e.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface GestionSpaceLibLocal {
    
    // cree une station pour la location location fournis
    // la list represente les nombres de places de chaque navette
    // le nombre de navette est créé
    // le nombre de quai créé représente le double du nombre de navette
    // les navettes sont affectés aux quais affectés à la station
    public void créerStation(List<Integer> nbPlaces, String loc );
    
    public List<Station> getSataions();
    
}
