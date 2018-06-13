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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    
    private String location;
    private String nomStation;

    public Station() {
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStation) {
        this.nomStation = nomStation;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stationDepart")
    private List<Voyage> voyage;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "station")
    private List<Quai> quais;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "station")
    private List<Mecanicien> mecaniciens;
     
    public Station(Map<Integer, Integer> quais, Localisation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Voyage> getVoyage() {
        return voyage;
    }

    public void setVoyage(List<Voyage> voyage) {
        this.voyage = voyage;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Quai> getQuais() {
        return quais;
    }

        
    public static int tempsTrajet(Station sDepart, Station sArriv){
            int temps=0;
            if(sDepart.getNomStation().equals("Terre")){
                switch(sArriv.getNomStation()){    
                     case "Terre":
                         break;
                     case "Dimidium":
                         temps=2;
                         break;
                     case "Arion":
                         temps=6;
                         break;
                     case "Brahe":
                         temps=2;
                         break;
                     case "Amateru":
                         temps=4;
                         break;
                     case "Tadmor":
                         temps=2;
                         break;
                }
            }
             if(sDepart.getNomStation().equals("Dimidium")){
                switch(sArriv.getNomStation()){    
                     case "Terre":
                         temps=2;
                         break;
                     case "Dimidium":
                         break;
                     case "Arion":
                         temps=6;
                     case "Brahe":
                         temps=4;
                     case "Amateru":
                         temps=6;
                     case "Tadmor":
                         temps=4;
                }
            }
             if(sDepart.getNomStation().equals("Arion")){
                switch(sArriv.getNomStation()){    
                 case "Terre":
                     temps=6;
                     break;
                 case "Dimidium":
                     temps=6;
                     break;
                 case "Arion":
                     break;
                 case "Brahe":
                     temps=6;
                     break;
                 case "Amateru":
                     temps=8;
                     break;
                 case "Tadmor":
                     temps=6;
                     break;
                 }
            }
            
                if(sDepart.getNomStation().equals("Brahe")){
                switch(sArriv.getNomStation()){    
                 case "Terre":
                     temps=2;
                     break;
                 case "Dimidium":
                     temps=4;
                     break;
                 case "Arion":
                     temps=6;
                     break;
                 case "Brahe":
                     break;
                 case "Amateru":
                     temps=4;
                     break;
                 case "Tadmor":
                     temps=2;
                     break;
                }
            }
                if(sDepart.getNomStation().equals("Amateru")){
                switch(sArriv.getNomStation()){    
                 case "Terre":
                     temps=4;
                     break;
                 case "Dimidium":
                     temps=6;
                     break;
                 case "Arion":
                     temps=8;
                     break;
                 case "Brahe":
                     temps=4;
                     break;
                 case "Amateru":
                     break;
                 case "Tadmor":
                     temps=2;
                     break;
            }
        }
                
        if(sDepart.getNomStation().equals("Tadmor")){
                switch(sArriv.getNomStation()){    
                 case "Terre":
                     temps=2;
                     break;
                 case "Dimidium":
                     temps=4;
                     break;
                 case "Arion":
                     temps=6;
                     break;
                 case "Brahe":
                     temps=2;
                     break;
                 case "Amateru":
                     temps=2;
                     break;
                 case "Tadmor":
                     break;
            }
        }
        return temps;
    }
              
    public void setQuais(List<Quai> quais) {
        this.quais = quais;
    }
    
    public void addQuai(Quai quai) {
        this.quais.add(quai);
    }

    public List<Mecanicien> getMecaniciens() {
        return mecaniciens;
    }

    public void setMecaniciens(List<Mecanicien> mecaniciens) {
        this.mecaniciens = mecaniciens;
    }
    

     
    public Long getId() {
        return id;
    }

    public Station(String loc) {
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
        return "com.j2e.entities.Station[ id=" + id + " nom de ls station : "+ nomStation+"]";
    }
    
}
