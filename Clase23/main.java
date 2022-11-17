import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {

    private static final HttpClient httpClient = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_1_1)
    .connectTimeout(Duration.ofSeconds(10))
    .build();

 
    public void run() { 
        HttpRequest request = HttpRequest.newBuilder()
        //.uri(URI.create("http://192.168.161.55:8080/searchtoken"))
        .uri(URI.create("http://localhost:8082/searchToken"))
        .header("X-Debug", "true")
        .POST(BodyPublishers.ofString("17576000,IPN"))
        .build();

        try {
            try{
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                // print response headers
                HttpHeaders headers = response.headers();
                headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
                // print status code
                System.out.println(response.statusCode());
                // print response body
                System.out.println("servidor 8082: "+response.body());

            }catch(InterruptedException a){
                System.out.println(a);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

  
}

public class main {

   
    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        ExecutorService pool = Executors.newFixedThreadPool(4); 
        Runnable r1 = new Task();
        // Runnable r2 = new Task();
        // Runnable r3 = new Task();
        // Runnable r4 = new Task();
    
        for(int a = 0; a<i;a++){
            
            pool.execute(r1);
            
            // pool.execute(r2);
            
            // pool.execute(r3);
            
            // pool.execute(r4);
            // Runnable r5 = new Task();
            // pool.execute(r5);
            // Runnable r6 = new Task();
            // pool.execute(r6);
            // Runnable r7 = new Task();
            // pool.execute(r7);
            // Runnable r8 = new Task();
            // pool.execute(r8);     
        }
        
        pool.shutdown();
       
         
         //ExecutorService pool = Executors.newFixedThreadPool(3);  
          
        

    }
}