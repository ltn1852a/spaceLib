package com.j2e.spacelibadmin;

import javax.naming.NamingException;

public class Launcher {
    
    
    public static void main(String[] args){
        try{
            RMIAdminServiceManager rmiMgr = new RMIAdminServiceManager();
            AdminCli cli = new AdminCli(rmiMgr.getCollabRemoteSvc());
            cli.run();
        }catch(NamingException ex){
            System.err.println("Erreur d'initialisation RMI : " + ex.getMessage());
            System.err.println(ex.getExplanation());
        }
        
    }
}
