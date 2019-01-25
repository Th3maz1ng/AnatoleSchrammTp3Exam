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
import tp3progrepartie.modelPartie1.GetStatus;

/**
 *
 * @author Think
 */
public class Tp3ProgRepartie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            GetStatus gs = (new GetStatus(4)).startVerif();
            
            //On affiche les resultats
            for(int i = 0;i < gs.getReponses().size(); i++)
            {
                System.out.println("Reponse : "+gs.getReponses().get(i)+" pour "+gs.getWebSiteList()[i]);
            }
    }
    
}
