/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.services;

import com.j2e.exceptions.StationNotFoundException;
import com.j2e.business.Localisation;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author maha-
 */
@Remote
public interface ServicesAdminRemote {
    public void créerStation(Map<Integer,Integer> quais, Localisation loc );
    public void créerNavette(int nbPlaces, int idStation)throws StationNotFoundException;
    public void créerQuai(int idStation)throws StationNotFoundException;
    
}
