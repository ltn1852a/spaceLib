/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacelibusager;

import com.j2e.business.HistoVoyage;
import com.j2e.exceptions.PwdIncorrectException;
import com.j2e.exceptions.VoyageAlreadyFinishedException;
import com.j2e.exceptions.VoyageNotFoundException;
import com.j2e.exceptions.navettesNotAvailableException;
import com.j2e.exceptions.quaisNotAvailableException;
import com.j2e.exceptions.reservationNotFoundException;
import com.j2e.exceptions.userAlreadyExistsException;
import com.j2e.exceptions.userNotFoundException;
import com.j2e.services.ServicesUsagerRemote;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;

/**
 *
 * @author maha-
 */
public class UsagerCli {
    
    private final ServicesUsagerRemote services;
    private final Scanner scanner = new Scanner(System.in);
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY' à 'HH:mm");
    
        public UsagerCli(ServicesUsagerRemote services) {
        this.services = services;
    }
        
        public void run() {
        int choix = -1;
        do {
            try{
                showMenu();
                choix = (int) CLIUtils.saisirEntier(scanner, "Votre choix : ", 0, 5);
                switch (choix) {
                    case 1:
                        this.créerCompte();
                        this.askNext();
                        break;
                    case 2:
                        this.réserverVoyage();
                        this.askNext();
                        break;
                    case 3:
                        this.finaliserVoyage();
                        this.askNext();
                        break;
                    case 4:
                        this.consulterHistVoyage();
                        this.askNext();
                        break;
                    case 5:
                        this.consulterStations();
                        this.askNext();
                        break;
                    case 6:
                        this.cloturerResa();
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
            //identification
        CLIUtils.afficherTitreSection("Menu d'identification");
        if(this.identifierUsager()){
        CLIUtils.afficherTitreSection("Menu de séléction");
        System.out.println("\t1. Création Compte usager");
        System.out.println("\t2. Réserver voyage");
        System.out.println("\t3. Finaliser voyage");
        System.out.println("\t3. Consulter la liste des stations");
        System.out.println("\t3. Cloturer réservation");
        System.out.println("\t4. Consulter historique voyage");
        System.out.println("\t0. Quitter");
        }else{
            System.out.println("Vous avez échoué de vous identifier, si vous possédez pas de compte, merci d'en créer un");
            this.créerCompte();
            this.askNext();            
        }
    }    
     
    private void quitter() {
        CLIUtils.afficherTitreSection("Au revoir");
    }
    
    private void askNext(){
        System.out.println("Appuyez sur la touche entrée pour continuer");
        try{
            System.in.read();
        }catch(IOException ex){};
    }
        
    public boolean  identifierUsager(){        
        final String pseudo = CLIUtils.saisirChaine(scanner, "Entrez votre pseudo : ");
        final String mdp = CLIUtils.saisirChaine(scanner, "Enntrez votre mot de passe : ");
        
        try{
              this.services.identifierUsager(pseudo, mdp);
              //identification faite avec succès
              return true;
        }catch(Exception ex){            
            System.out.println("Erreur : " + ex.getMessage());
            return false;
        }
             
    }
    
    public void consulterStations(){
        this.services.consulterListeStation();
    }
    
    public void créerCompte(){
        final String pseudo = CLIUtils.saisirChaine(scanner, "Choisissez un pseudo : ");
        final String mdp = CLIUtils.saisirChaine(scanner, "choisissez un mot de passe : ");
                try{
              this.services.créerCompte(pseudo, mdp);
              
        }catch(Exception ex){            
            System.out.println("Erreur : " + ex.getMessage());
        }
    }

    private void finaliserVoyage() {        
        final Long idVoyage = CLIUtils.saisirEntier(scanner, "Entrez l identifiant du voyage que vous souhaitez finaliser : ");
        try{
            services.finaliserVoyage(idVoyage);
        }catch(Exception ex){
            System.out.println("Erreur : " + ex.getMessage());
            
        }
    }

    private void réserverVoyage() {
        
        Long idUsager = CLIUtils.saisirEntier(scanner, "Entrez votre id : ");
        
        int nbVoyage =(int) CLIUtils.saisirEntier(scanner, "Entrez le nombre de voyageurs : ");
        Long stationDepart= CLIUtils.saisirEntier(scanner, "Entrez l id de la station de départ: ");
        Long stationArriv= CLIUtils.saisirEntier(scanner, "Entrez l id de la station d'arrivéer: ");
        try{
            services.réserverVoyage(idUsager, nbVoyage, stationDepart, stationArriv);
        }catch(Exception ex){
            System.out.println("Erreur : " + ex.getMessage()); 
        }
    }

    private void consulterHistVoyage() {
        Long idUser = CLIUtils.saisirEntier(scanner, "Entrez votre id : ");
        
        try{
           ArrayList hist = (ArrayList) services.consulterHistVoyage(idUser);
           afficherHistorique(hist);
        }catch(Exception ex){            
            System.out.println("Erreur : " + ex.getMessage()); 
        }
        
    }
    
    private void afficherHistorique(ArrayList<HistoVoyage> HistoVoyage){
        for(int i=0; i< HistoVoyage.size();i++){
            System.out.println(HistoVoyage.get(i).toStringHistoVoyage());
        }
    }

    private void cloturerResa() {
        
        Long idResa = CLIUtils.saisirEntier(scanner, "Entrez l' id de la réservation que vous souhaitez cloturer : ");
        try {
            services.cloturerRéservation(idResa);
        } catch (reservationNotFoundException ex) {
            Logger.getLogger(UsagerCli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
