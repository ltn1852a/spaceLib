/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoRevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface HistoRevisionFacadeLocal {

    void create(HistoRevision histoRevision);

    void edit(HistoRevision histoRevision);

    void remove(HistoRevision histoRevision);

    HistoRevision find(Object id);

    List<HistoRevision> findAll();

    List<HistoRevision> findRange(int[] range);

    int count();
    
}
