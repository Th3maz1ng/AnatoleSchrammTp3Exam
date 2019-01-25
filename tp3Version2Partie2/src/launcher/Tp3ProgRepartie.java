/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelPartie2.Ramasseur;

/**
 *
 * @author Think
 */
public class Tp3ProgRepartie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            Ramasseur r = (new Ramasseur(10)).letsPickBananas();
            System.out.println("Number of bananas : "+r.getNbOfBananasCollected());
            
            System.out.println("Number of bananas by counting : "+r.getNbOfBananasCollectedByCounting());
            
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } catch (ExecutionException ex) {
            System.out.println(ex.getMessage());
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
