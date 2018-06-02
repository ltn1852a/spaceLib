/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.repositories;

import com.j2e.entities.Usager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yannl
 */
@Stateless
public class UsagerFacade extends AbstractFacade<Usager> implements UsagerFacadeLocal {

    @PersistenceContext(unitName = "spaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsagerFacade() {
        super(Usager.class);
    }

    @Override
    public Usager finByPseudoAndMdp(String pseudo, String mdp) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usager> cq = cb.createQuery(Usager.class);
        Root<Usager> root = cq.from(Usager.class);
        cq.where(
                cb.and(
                        cb.equal(cb.upper(root.get("pseudo").as(String.class)), pseudo.toUpperCase()),
                        cb.equal(cb.upper(root.get("mdp").as(String.class)), mdp.toUpperCase())
                )
        );

        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @Override
    public Usager finByPseudo(String pseudo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usager> cq = cb.createQuery(Usager.class);
        Root<Usager> root = cq.from(Usager.class);
        cq.where(
                cb.equal(cb.upper(root.get("pseudo").as(String.class)), pseudo.toUpperCase())
        );

        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @Override
    public void créerCompteUsager(String pseudo, String mdp) {
        Usager nouveauUsager = new Usager(pseudo, mdp);
        this.create(nouveauUsager);

    }

}
