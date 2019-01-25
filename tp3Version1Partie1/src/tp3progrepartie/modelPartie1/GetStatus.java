/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3progrepartie.modelPartie1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Think
 */
public class GetStatus {
    private String[] webSiteList = {"http://crunchify.com", "http://yahoo.com",
"http://www.ebay.com", "http://google.com",
"http://www.example.co", "https://paypal.com",
"http://bing.com/", "http://techcrunch.com/",
"http://mashable.com/", "http://thenextweb.com/",
"http://wordpress.com/", "http://wordpress.org/",
"http://example.com/", "http://sjsu.edu/",
"http://ebay.co.uk/", "http://google.co.uk/",
"http://www.wikipedia.org/",
"http://en.wikipedia.org/wiki/Main_Page","http://127.0.0.1:8080/phpinfo.php"};
    
    private ExecutorService executor = null;

    public GetStatus(int numberOfThreads) {
        executor = Executors.newFixedThreadPool(numberOfThreads);
    }
    
    public void startVerif()
    {
        for(String site : webSiteList)
        {
            executor.execute(new WebVerif(site));
        }
        
        executor.shutdown();
        
        while(!executor.isTerminated());
        
        System.out.println("Done!!!");
    }
}
