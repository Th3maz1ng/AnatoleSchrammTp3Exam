/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelPartie2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Think
 */
public class Ramasseur {
    
    private int nbOfBananasCollected = 0;
    private ExecutorService executor = null;
    private ArrayList<Integer> casiers;
    private int nbMonkeys = 0;
    private Semaphore s = null;
    
    //Business logic
    private Singe[] tabSinge = null;
    private FutureTask<Integer>[] tabFutureTask = null;
    
    public Ramasseur(int nbMonkeys) {
        s = new Semaphore(1);
        this.nbMonkeys = nbMonkeys;
        
        executor = Executors.newFixedThreadPool(this.nbMonkeys);
        casiers = new ArrayList(this.nbMonkeys);
        
        tabSinge = new Singe[this.nbMonkeys];
        tabFutureTask = new FutureTask[this.nbMonkeys];
        
        for(int i = 0; i < this.nbMonkeys;i++)
        {
            tabSinge[i] = new Singe(casiers,s);
            tabFutureTask[i] = new FutureTask<Integer>(tabSinge[i]);
        }
                
    }

    public int getNbOfBananasCollected() {
        return nbOfBananasCollected;
    }
    
    public Ramasseur letsPickBananas() throws InterruptedException, ExecutionException, TimeoutException
    {
        for(int i = 0; i < nbMonkeys; i++)
        {
            executor.execute(tabFutureTask[i]);
        }
        
       /* while(true)
        {
            int done = 0;
            for(int i = 0; i < nbMonkeys; i++)
            {
                if(tabFutureTask[i].isDone()){
                    done++;
                }
            }
            
            if(done == nbMonkeys)
            {
                System.out.println("Picking is done : "+done);
                executor.shutdown();
                break;
            }
        }*/
        executor.shutdown();
        while(!executor.isTerminated());
        
        for(int i = 0; i < nbMonkeys; i++)
        { 
            if(tabFutureTask[i].isDone())nbOfBananasCollected += tabFutureTask[i].get(); 
        }
        return this;
    }

    public int getNbOfBananasCollectedByCounting() {
        int total = 0;
        for(int i = 0;i < nbMonkeys; i++)total +=casiers.get(i);
        return total;
    }
}
