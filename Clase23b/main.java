import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;


public class main {

   
    public static void main (String[] args) throws IOException, InterruptedException {


        int n = Integer.parseInt(args[0]);
    
        ExecutorService pool = Executors.newFixedThreadPool(100);  

        for (int i = 0; i < n; i++) {
            Runnable r = new Task();
            pool.execute(r);
            Runnable r2 = new Task();
            pool.execute(r2);
            Runnable r3 = new Task();
            pool.execute(r3);
            Runnable r4 = new Task();
            pool.execute(r4);
            Runnable r5 = new Task();
            pool.execute(r5);
            Runnable r6 = new Task();
            pool.execute(r6);
            Runnable r7 = new Task();
            pool.execute(r7);
            Runnable r8 = new Task();
            pool.execute(r8);
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
     

    }
}