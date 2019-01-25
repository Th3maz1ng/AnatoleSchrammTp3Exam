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
        
            (new GetStatus(4)).startVerif();
    }
    
}
