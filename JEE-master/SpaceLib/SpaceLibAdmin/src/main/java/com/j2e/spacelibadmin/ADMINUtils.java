/*
 * Copyright (C) 2018 Rémi Venant $lt;remi.venant@gmail.com$gt;.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.j2e.spacelibadmin;

import java.util.Scanner;

/**
 *
 * @author Yann Lattes;
 */
public class ADMINUtils {

    private ADMINUtils() {
    }
    
    public static void afficherTitreSection(String titre){
        System.out.println();
        System.out.println("***** " + titre.toUpperCase() + "*****");
        System.out.println();
    }
    
    public static float saisirFloat(Scanner sc, String label, float limiteInf, float limiteMax){
        do{
            try{
                System.out.print(label);
                float f = Float.parseFloat(sc.next());
                if(f < limiteInf || f > limiteMax){
                    throw new NumberFormatException("nombre incorrect");
                }
                return f;
            }catch(NumberFormatException ex){
                System.out.println("Erreur de saisie : " + ex.getMessage());
            }
        }while(true);
    }
    
    public static double saisirDouble(Scanner sc, String label, double limiteInf, double limiteMax){
        do{
            try{
                System.out.print(label);
                double d = Double.parseDouble(sc.next());
                if(d < limiteInf || d > limiteMax){
                    throw new NumberFormatException("nombre incorrect");
                }
                return d;
            }catch(NumberFormatException ex){
                System.out.println("Erreur de saisie : " + ex.getMessage());
            }
        }while(true);
    }
    
    public static double saisirDouble(Scanner sc, String label){
        return saisirDouble(sc, label, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
     public static float saisirFloat(Scanner sc, String label){
        return saisirFloat(sc, label, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }
    
    public static long saisirEntier(Scanner sc, String label, long limiteInf, long limiteMax){
        do{
            try{
                System.out.print(label);
                long d = Long.parseLong(sc.next());
                if(d < limiteInf || d > limiteMax){
                    throw new NumberFormatException("nombre incorrect");
                }
                return d;
            }catch(NumberFormatException ex){
                System.out.println("Erreur de saisie : " + ex.getMessage());
            }
        }while(true);
    }
    
    public static long saisirEntier(Scanner sc, String label){
        return saisirEntier(sc, label, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static String saisirChaine(Scanner sc, String label){
        do{
            System.out.print(label);
            String c = sc.next();
            c = c == null ? null : c.trim();
            if(c == null || c.isEmpty()){
                System.out.println("Erreur de sasisie : veuillez saisir au moins un caractère.");
            }else{
                return c;
            }
        }while(true);
    }
}
