/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;


import com.j2e.exceptions.StationNotFoundException;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * 
 * 
 * kkkkk
 * @author maha-
 */
@Remote
public interface GestionSpaceLibRemote {
    public void créerStation(List<Integer> nbPlaces, Localisation loc );
}
