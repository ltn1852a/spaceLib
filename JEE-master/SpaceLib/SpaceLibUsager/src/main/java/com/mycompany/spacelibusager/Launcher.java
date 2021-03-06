package com.mycompany.spacelibusager;

import javax.naming.NamingException;

public class Launcher {
    
    
    public static void main(String[] args){
       try{
            RMIUsagerServiceManager rmiMgr = new RMIUsagerServiceManager();
            UsagerCli cli = new UsagerCli(rmiMgr.getUsagerRemoteSvc());
            cli.run();
        }catch(NamingException ex){
            System.err.println("Erreur d'initialisation RMI : " + ex.getMessage());
            System.err.println(ex.getExplanation());
        }
        
    }
}
