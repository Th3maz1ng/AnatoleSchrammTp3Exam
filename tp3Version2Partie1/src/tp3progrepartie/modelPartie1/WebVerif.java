/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3progrepartie.modelPartie1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Think
 */
public class WebVerif implements Runnable {
    private String urlToTest = "";
    private Integer response = 0;
    private Hashtable<Integer,String> rep = null;//Collection thread safe
    private Integer myId = 0;

    public WebVerif(String urlToTest, Hashtable<Integer,String> rep, Integer i) {
        this.urlToTest = urlToTest;
        this.rep = rep;
        myId = i;
    }
    
    
    @Override
    public void run() {
        try {
            URL url = new URL(urlToTest);
            
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.connect();
            response = huc.getResponseCode();
            rep.put(myId,response.toString());
        }catch (MalformedURLException ex) {
            rep.put(myId,"This URL isn't valid");
        }catch (IOException ex){
            rep.put(myId,"Couldn't connect to site : "+urlToTest);
        }
    }

    public int getResponse() {
        return response;
    }
}
