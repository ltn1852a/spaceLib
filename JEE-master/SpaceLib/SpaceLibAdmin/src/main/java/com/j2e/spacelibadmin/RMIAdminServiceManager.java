/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.spacelibadmin;

import com.j2e.services.ServicesAdminRemote;
import com.j2e.services.ServicesUsagerRemote;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Yann Lattes
 */
public class RMIAdminServiceManager {
    private final static String GLASSFISH_ORB_HOST = "localhost";
    private final static String GLASSFISH_ORB_PORT = "3700";
    
    //lien 
    private final static String SERVICES_ADMIN_EJB_URI = "java:global/SpaceLib-ear/SpaceLib-ejb-1.0-SNAPSHOT/ServicesAdmin!com.j2e.services.ServicesAdminRemote";
    
    private InitialContext namingContext;
    private ServicesAdminRemote adminRemoteSvc;
    
        public RMIAdminServiceManager() throws NamingException {
        this.initJndi();
        this.retrieveRemoteServicesAdmin();
    }
        
        private void initJndi() throws NamingException {
        Properties jNDIProperties = new Properties();
        jNDIProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialHost", GLASSFISH_ORB_HOST);
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialPort", GLASSFISH_ORB_PORT);
        this.namingContext = new InitialContext(jNDIProperties);
    } 
        
        private void retrieveRemoteServicesAdmin() throws NamingException {
        this.adminRemoteSvc = (ServicesAdminRemote) this.namingContext.lookup(SERVICES_ADMIN_EJB_URI);
    }
        
            public ServicesAdminRemote getCollabRemoteSvc() {
        return adminRemoteSvc;
    }
    
}
