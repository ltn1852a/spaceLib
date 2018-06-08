/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author yannl
 */
@Entity
public class Voyage implements Serializable {
    public enum Etat{Initié,Finalisé};
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbPassager;
    private SimpleDateFormat dateDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateArrivee;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voyage")
    private List<Reservation> listReservation;

    public Voyage() {
    }

    public Navette getNavette() {
        return navette;
    }

    public void setNavette(Navette navette) {
        this.navette = navette;
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
    }

    public Station getStationArrive() {
        return stationArrive;
    }

    public Voyage(int nbPassager, SimpleDateFormat dateDepart, Date dateArrivee, Navette navette, Station stationDepart, Station stationArrive) {
        this.nbPassager = nbPassager;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.navette = navette;
        this.stationDepart = stationDepart;
        this.stationArrive = stationArrive;
        this.etat=Etat.Initié;
        this.listReservation=new ArrayList<Reservation>();
        this.histoVoyage=new ArrayList<HistoVoyage>();
    }

    public void setStationArrive(Station stationArrive) {
        this.stationArrive = stationArrive;
    }
    
   @OneToMany(fetch = FetchType.EAGER, mappedBy = "voyage")
    private List<HistoVoyage> histoVoyage;
   
   @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_NAVETTE", nullable = false)
    private Navette navette;

    public List<HistoVoyage> getHistoVoyage() {
        return histoVoyage;
    }

    public void setHistoVoyage(List<HistoVoyage> histoVoyage) {
        this.histoVoyage = histoVoyage;
    }

   @ManyToOne(optional = false, fetch = FetchType.EAGER)
   @JoinColumn(name = "ID_STATIONDEPART", nullable = false)
    private Station stationDepart;
   
   @ManyToOne(optional = false, fetch = FetchType.EAGER)
   @JoinColumn(name = "ID_STATIONARRIVE", nullable = false)
    private Station stationArrive;
   
    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }
    
    public void addReservation(Reservation r){
        this.listReservation.add(r);
    }
    public void enleverReservation(Reservation r){
        this.listReservation.remove(r);
    }
    private Etat etat;

    public int getNbPassager() {
        return nbPassager;
    }

    public void setNbPassager(int nbPassager) {
        this.nbPassager = nbPassager;
    }

    public SimpleDateFormat getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(SimpleDateFormat dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
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
        if (!(object instanceof Voyage)) {
            return false;
        }
        Voyage other = (Voyage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2e.entities.Voyage[ id=" + id + " ]";
    }
    
}
