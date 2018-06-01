/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.HistoNavette;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface HistoNavetteFacadeLocal {

    void create(HistoNavette histoNavette);

    void edit(HistoNavette histoNavette);

    void remove(HistoNavette histoNavette);

    HistoNavette find(Object id);

    List<HistoNavette> findAll();

    List<HistoNavette> findRange(int[] range);

    int count();
    
}
