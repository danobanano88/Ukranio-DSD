
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class clientTask implements Runnable {

    private String name;
    private HttpRequest request;
    private HttpClient client;
    public clientTask(String str, HttpRequest rqst, HttpClient cl) {
        this.name = str;
        this.request = rqst;
        this.client = cl;
    }

    
    public void run() {
        try {
            HttpResponse<String> response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
            // print response headers
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
            // print status code
            System.out.println(response.statusCode());
            // print response body
            System.out.println(response.body());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}