/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author yannl
 */
@Entity
public class Navette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbPLaces;
    private boolean disponible;

    @OneToMany
    private List<Voyage> voyages;
    
    @OneToMany
    private List<HistoNavette> histoNavettes;
    
    
    @OneToMany
    private List<HistoRevision> histoRevision;

    public Navette(int nbPLaces) {
        this.nbPLaces = nbPLaces;
        this.disponible=true;
        this.histoNavettes = new ArrayList<HistoNavette>();
        this.histoRevision= new ArrayList<HistoRevision>();
        
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public List<HistoNavette> getHistoNavettes() {
        return histoNavettes;
    }

    public void setHistoNavettes(List<HistoNavette> histoNavettes) {
        this.histoNavettes = histoNavettes;
    }

    public List<HistoRevision> getHistoRevision() {
        return histoRevision;
    }

    public void setHistoRevision(List<HistoRevision> histoRevision) {
        this.histoRevision = histoRevision;
    }
        
    public int getNbPLaces() {
        return nbPLaces;
    }

    public void setNbPLaces(int nbPLaces) {
        this.nbPLaces = nbPLaces;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean diponible) {
        this.disponible = diponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Navette)) {
            return false;
        }
        Navette other = (Navette) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2e.entities.Navette[ id=" + id + " ]";
    }
    
}
