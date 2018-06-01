/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoVoyage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface HistoVoyageFacadeLocal {

    void create(HistoVoyage histoVoyage);

    void edit(HistoVoyage histoVoyage);

    void remove(HistoVoyage histoVoyage);

    HistoVoyage find(Object id);

    List<HistoVoyage> findAll();

    List<HistoVoyage> findRange(int[] range);
    
    List<com.j2e.business.HistoVoyage> findByUsager(Long idUsager);

    int count();
    
}
