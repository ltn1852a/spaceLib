/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author yannl
 */
@Entity
public class Reservation implements Serializable {
      /*@Temporal(TemporalType.TIMESTAMP)
    private Calendar dateInterrogation;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compte")
    private List<OperationCompte> operations;*/
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateResa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usager usager;
    
     @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Voyage voyage;

    public Date getDateResa() {
        return dateResa;
    }

    public Reservation(Usager usager, Voyage voyage) {
        this.usager = usager;
        this.voyage = voyage;
        this.dateResa=new Date();
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2e.entities.Reservation[ id=" + id + " ]";
    }
    
}
