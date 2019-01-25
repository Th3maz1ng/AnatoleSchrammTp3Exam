/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelPartie2;

import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Callable;

/**
 *
 * @author Think
 */
public class Singe implements Callable<Integer>{
    private static int instanceId = 0;
    private Random rand = null;
    private Hashtable<Integer,Vector<Banane>> casiers = null;
    private int myId = 0;

    public Singe(Hashtable<Integer,Vector<Banane>> casiers) {
        myId = instanceId++;
        rand = new Random();
        this.casiers = casiers;
    }
    
    
    @Override
    public Integer call() throws Exception {
        int myRand = rand.nextInt(20);
        System.out.println("Monkey with id : "+myId+" picked : "+myRand);
        Vector<Banane> vb = new Vector<>();
        
        for(int i = 0; i < myRand; i++){
            vb.add(new Banane());
        }
        
        casiers.put(myId,vb);
        
        System.out.println("Monkey with id : "+myId+" done picking");
        return myRand;
    }
}
