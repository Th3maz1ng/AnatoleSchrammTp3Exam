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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Think
 */
public class WebVerif implements Runnable {
    private String urlToTest = "";
    private int response = 0;

    public WebVerif(String urlToTest) {
        this.urlToTest = urlToTest;
    }
    
    
    @Override
    public void run() {
        try {
            URL url = new URL(urlToTest);
            
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.connect();
            response = huc.getResponseCode();
            System.out.println("Response "+response+" from site : "+urlToTest);
        }catch (MalformedURLException ex) {
            System.out.println("This URL isn't valid");
        }catch (IOException ex){
            System.out.println("Couldn't connect to site : "+urlToTest);
            System.out.println("Reason : "+ex.getMessage());
        }
    }

    public int getResponse() {
        return response;
    }
}
