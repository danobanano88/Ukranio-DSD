import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;

class Task implements Runnable {
    private static final HttpClient httpClient = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_1_1)
    .connectTimeout(Duration.ofSeconds(10))
    .build();
   
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://192.168.0.21:8082/searchToken"))
    .header("X-Debug", "true")
    .POST(BodyPublishers.ofString("1757600,IPN"))
    .build();

    public void run() {
        try{
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println("servidor 8082: "+response.body());
    }catch(Exception e){
        System.out.println("Exception is caught");
    }

    }
 
}