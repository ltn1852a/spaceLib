/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.Quai;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maha-
 */
@Local
public interface QuaiFacadeLocal {

    void create(Quai quai);

    void edit(Quai quai);

    void remove(Quai quai);

    Quai find(Object id);

    List<Quai> findAll();

    List<Quai> findRange(int[] range);

    int count();
    
}
