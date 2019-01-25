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
    private Hashtable<Integer,Integer> casiers = null;
    private int myId = 0;

    public Singe(Hashtable<Integer,Integer> casiers) {
        myId = instanceId++;
        rand = new Random();
        this.casiers = casiers;
    }
    
    
    @Override
    public Integer call() throws Exception {
        int myRand = rand.nextInt(20);
        System.out.println("Monkey with id : "+myId+" picked : "+myRand);
        casiers.put(myId, myRand);
        System.out.println("Monkey with id : "+myId+" done picking");
        return myRand;
    }
}
