/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author yannl
 */
@Entity
public class HistoVoyage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   @ManyToOne(optional = false, fetch = FetchType.EAGER)
   @JoinColumn(name = "ID_VOYAGE", nullable = false)
    private Voyage voyage;

    public HistoVoyage() {
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public HistoVoyage(Voyage voyage, String text) {
        this.voyage = voyage;
        this.text = text;
    }
    
    public String getTSext() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String toStringHistoVoyage(){
        String s ="[";
        String dateDepart = this.voyage.getDateDepart().toString();
        String dateArriv = this.voyage.getDateArrivee().toString();
        String stationDepart = this.voyage.getStationDepart().getNomStation();
        String stationArrivee = this.voyage.getStationArrive().getNomStation();
        
        s += "Voyage effectué au départ de la station"+ stationDepart +"à la date "+dateDepart+" dont la destination est "+stationArrivee+ "atteinte à la date "+dateArriv+"]";
        return s;
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
        if (!(object instanceof HistoVoyage)) {
            return false;
        }
        HistoVoyage other = (HistoVoyage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2e.entities.HistoVoyage[ id=" + id + " ]";
    }
    
}
