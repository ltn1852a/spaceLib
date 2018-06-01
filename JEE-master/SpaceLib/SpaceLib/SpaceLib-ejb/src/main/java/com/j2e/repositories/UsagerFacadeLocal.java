/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.Usager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yannl
 */
@Local
public interface UsagerFacadeLocal {

    void create(Usager usager);

    void edit(Usager usager);

    void remove(Usager usager);

    Usager find(Object id);

    List<Usager> findAll();

    List<Usager> findRange(int[] range);

    int count();
    
    Usager finByPseudoAndMdp(String pseudo, String mdp);
    
    Usager finByPseudo(String pseudo);

    public void créerCompteUsager(String pseudo, String mdp);
    
}
