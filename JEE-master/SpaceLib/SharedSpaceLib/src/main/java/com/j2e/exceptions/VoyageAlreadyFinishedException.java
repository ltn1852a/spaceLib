/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.exceptions;

/**
 *
 * @author maha-
 */
public class VoyageAlreadyFinishedException extends Exception {

    public VoyageAlreadyFinishedException() {
        super("voyage déja finalisé");
    }
    
}
