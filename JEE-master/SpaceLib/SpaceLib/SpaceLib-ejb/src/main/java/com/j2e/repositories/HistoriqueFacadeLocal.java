/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.Historique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface HistoriqueFacadeLocal {

    void create(Historique historique);

    void edit(Historique historique);

    void remove(Historique historique);

    Historique find(Object id);

    List<Historique> findAll();

    List<Historique> findRange(int[] range);

    int count();
    
}
