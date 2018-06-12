/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2e.spacelibadmin;


import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageAlreadyFinishedException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.navettesNotAvailableException;
import com.j2e.exceptions.quaisNotAvailableException;
import com.j2e.exceptions.userAlreadyExistsException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.services.ServicesAdminRemote;
import com.j2e.services.ServicesUsagerRemote;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.ejb.EJBException;

/**
 *
 * @author Yann Lattes
 */
public class AdminCli {
    
    private final ServicesAdminRemote services;
    private final Scanner scanner = new Scanner(System.in);
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY' à 'HH:mm");
    private final NumberFormat soldeFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    
        public AdminCli(ServicesAdminRemote services) {
        this.services = services;
    }
        
        public void run() {
        int choix = -1;
        do {
            try{
                showMenu();
                choix = (int) ADMINUtils.saisirEntier(scanner, "Votre choix : ", 0, 1);
                switch (choix) {
                    case 1:
                        this.créerStation();
                        this.askNext();
                        break;
                    case 0:
                        this.quitter();
                        break;
                    default:
                        System.out.println("Erreur de choix");
                }
            }catch(EJBException ex){
                System.out.println("Erreur non gérée (" + ex.getClass().getName() + " : " + ex.getMessage() + ")");
                Throwable cause = ex.getCause();
                while(cause != null){
                    System.out.println("\tCause " + cause.getClass().getName() + " : " + cause.getMessage());
                    cause = cause.getCause();
                }
            }
        }while(choix != 0);
    }    
        
        private void showMenu() {

       // if(this.identifierUsager()){
        ADMINUtils.afficherTitreSection("Menu de séléction"); 
        System.out.println("\t0. Quitter");
        System.out.println("\t1. Création Station");
       
        //}else{
           // System.out.println("Vous avez échoué de vous identifier, si vous possédez pas de compte, merci d'en créer un");
            //this.créerCompte();
           // this.askNext();
            
      //  }
    }    
     
    private void quitter() {
        ADMINUtils.afficherTitreSection("Au revoir");
    }
    
    private void askNext(){
        System.out.println("Appuyez sur la touche entrée pour continuer");
        try{
            System.in.read();
        }catch(IOException ex){};
    }
        
    public boolean  créerStation(){
        try{
            final String nbPlacesString = ADMINUtils.saisirChaine(scanner, " Entrez le nombre de places pour chaques navettes : ");
            String[] places;
            System.out.println(nbPlacesString.split(" ").length);
            if(nbPlacesString.split(" ").length!=1){
               places=nbPlacesString.split(" ");
            }else{
                places=new String[1];
                places[0]=nbPlacesString;
            }
            List<Integer> nbPlaces=new ArrayList();
            for(String s : places){
                nbPlaces.add(Integer.parseInt(s));
            }
            final String loc = ADMINUtils.saisirChaine(scanner, "Entrez la localisation: ");
            System.out.print(nbPlaces);
            this.services.créerStation(nbPlaces, loc);
            return true;
        }catch(Exception e){
            return false;
        }
               
    }
}
