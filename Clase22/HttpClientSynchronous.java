import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;

public class HttpClientSynchronous {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws IOException, InterruptedException {

        // HttpRequest request = HttpRequest.newBuilder()
        //         .GET()
        //         .uri(URI.create("http://localhost:8082/status"))
        //         .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
        //         .build();
        // HttpRequest request = HttpRequest.newBuilder()
        // .uri(URI.create("http://localhost:8082/searchToken"))
        // .header("X-Debug", "true")
        // .POST(BodyPublishers.ofString("17576000,IPN"))
        // .build();

        // HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // // print response headers
        // HttpHeaders headers = response.headers();
        // headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // // print status code
        // System.out.println(response.statusCode());

        // // print response body
        // System.out.println(response.body());

      
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://172.26.71.72:8082/searchToken"))
            .header("X-Debug", "true")
            .POST(BodyPublishers.ofString("17576000,IPN"))
            .build();
    
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // print response headers
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
            // print status code
            System.out.println(response.statusCode());
            // print response body
            System.out.println("servidor 8082: "+response.body());


            HttpRequest request2 = HttpRequest.newBuilder()
            .uri(URI.create("http://192.168.161.55:8080/searchtoken"))
            .header("X-Debug", "true")
            .POST(BodyPublishers.ofString("17576000,IPN"))
            .build();
    
            HttpResponse<String> response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());
            // print response headers
            HttpHeaders headers2 = response2.headers();
            headers2.map().forEach((k, v) -> System.out.println(k + ":" + v));
            // print status code
            System.out.println(response2.statusCode());
            // print response body
            System.out.println("servidor 8080: "+response2.body());

        

    }

}