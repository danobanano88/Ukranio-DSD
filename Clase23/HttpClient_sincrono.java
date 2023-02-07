import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;

import java.net.http.HttpRequest;

import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HttpClient_sincrono {
    // Maximum number of threads in thread pool
    static final int MAX_T = 100;
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    public static void main(String[] args) throws IOException, InterruptedException {

        String argumentos = args[0];
        int num = Integer.parseInt(argumentos);
       
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/searchToken"))
                .header("X-Debug", "true")
                .POST(BodyPublishers.ofString("1757600,IPN"))
                .build();

        //Concurrent requests
        for(int i = 0; i < num; i++){
            String c = "" + (char)i ;
            Runnable r1 = new clientTask("task " + c , request, httpClient);
            pool.execute(r1);
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
      
    }
}