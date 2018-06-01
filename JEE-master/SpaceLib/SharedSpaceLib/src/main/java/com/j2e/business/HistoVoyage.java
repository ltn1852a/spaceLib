/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.business;

/**
 *
 * @author yannl
 */
public class HistoVoyage {
    private Long voyage;

    public Long getVoyage() {
        return voyage;
    }

    public void setVoyage(Long voyage) {
        this.voyage = voyage;
    }

    public HistoVoyage(Long voyage, String text) {
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

}
