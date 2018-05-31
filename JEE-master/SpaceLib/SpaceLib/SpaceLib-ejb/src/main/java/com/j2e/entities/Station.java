/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.entities;


import com.j2e.business.Localisation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author yannl
 */
@Entity
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Localisation location;

    @ManyToOne
    private List<Voyage> voyage;

    public Station(Map<Integer, Integer> quais, Localisation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Voyage> getVoyage() {
        return voyage;
    }

    public void setVoyage(List<Voyage> voyage) {
        this.voyage = voyage;
    }
    
    public Localisation getLocation() {
        return location;
    }

    public void setLocation(Localisation location) {
        this.location = location;
    }

    public List<Quai> getQuais() {
        return quais;
    }

    public void setQuais(List<Quai> quais) {
        this.quais = quais;
    }

    public List<Mecanicien> getMecaniciens() {
        return mecaniciens;
    }

    public void setMecaniciens(List<Mecanicien> mecaniciens) {
        this.mecaniciens = mecaniciens;
    }
    
    @OneToMany
    private List<Quai> quais;
    
     @OneToMany
    private List<Mecanicien> mecaniciens;
     
    public Long getId() {
        return id;
    }

    public Station(List<Quai> quais, List<Mecanicien> mecaniciens, Localisation loc) {
        this.quais = new ArrayList<Quai>();
        this.mecaniciens = new ArrayList<Mecanicien>();
        this.location= loc;
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
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2e.entities.Station[ id=" + id + " ]";
    }
    
}
