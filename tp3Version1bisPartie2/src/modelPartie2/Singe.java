/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelPartie2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Think
 */
public class Singe implements Callable<Integer>{
    private static int instanceId = 0;
    private Random rand = null;
    private ArrayList<Integer> casiers = null;
    private int myId = 0;
    private Semaphore s = null;

    public Singe(ArrayList<Integer> casiers, Semaphore s) {
        myId = instanceId++;
        rand = new Random();
        this.casiers = casiers;
        this.s = s;
    }
    
    
    @Override
    public Integer call() throws Exception {
        int myRand = rand.nextInt(20);
        System.out.println("Monkey with id : "+myId+" picked : "+myRand);
        s.acquire();
        System.out.println("I have the sem : "+myId);
        casiers.add(myRand);
        s.release();
        System.out.println("Monkey with id : "+myId+" done picking");
        return myRand;
    }
}
