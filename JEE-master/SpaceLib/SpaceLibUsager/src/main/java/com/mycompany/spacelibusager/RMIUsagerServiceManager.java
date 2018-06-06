/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacelibusager;

import com.j2e.services.ServicesUsagerRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author maha-
 */
public class RMIUsagerServiceManager {
    private final static String GLASSFISH_ORB_HOST = "localhost";
    private final static String GLASSFISH_ORB_PORT = "3700";
    
    //lien 
    private final static String SERVICES_COLL_EJB_URI = "lien a recuperer du lancement du ear";
    
    private InitialContext namingContext;
    private ServicesUsagerRemote usagerRemoteSvc;
    
        public RMIUsagerServiceManager() throws NamingException {
        //this.initJndi();
        this.retrieveRemoteServicesUsagers();
    }
        
            private void retrieveRemoteServicesUsagers() throws NamingException {
        this.usagerRemoteSvc = (ServicesUsagerRemote) this.namingContext.lookup(SERVICES_COLL_EJB_URI);
    }
    
}
