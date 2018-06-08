/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacelibusager;

import com.j2e.services.ServicesUsagerRemote;
import java.util.Properties;
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
    private final static String SERVICES_USAGER_EJB_URI = "java:global/SpaceLib-ear/SpaceLib-ejb-1.0-SNAPSHOT/ServicesUsager!com.j2e.services.ServicesUsagerRemote";
    
    private InitialContext namingContext;
    private ServicesUsagerRemote usagerRemoteSvc;
    
        public RMIUsagerServiceManager() throws NamingException {
        this.initJndi();
        this.retrieveRemoteServicesUsagers();
    }
        
        private void initJndi() throws NamingException {
        Properties jNDIProperties = new Properties();
        jNDIProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialHost", GLASSFISH_ORB_HOST);
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialPort", GLASSFISH_ORB_PORT);
        this.namingContext = new InitialContext(jNDIProperties);
    } 
        
        private void retrieveRemoteServicesUsagers() throws NamingException {
        this.usagerRemoteSvc = (ServicesUsagerRemote) this.namingContext.lookup(SERVICES_USAGER_EJB_URI);
    }
        
        public ServicesUsagerRemote getCollabRemoteSvc() {
        return usagerRemoteSvc;
    }

    ServicesUsagerRemote getUsagerRemoteSvc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
