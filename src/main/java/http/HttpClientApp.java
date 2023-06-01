package http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientApp {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        String url = "https://www.baidu.com";
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, "UTF-8");
        System.out.println(res);

    }
}
