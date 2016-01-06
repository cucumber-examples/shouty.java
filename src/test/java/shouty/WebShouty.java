package shouty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import shouty.web.ShoutyWebServer;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebShouty implements Shouty {

    private final ShoutyWebServer server;

    public WebShouty() {
        server = new ShoutyWebServer(8080);

        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setLocation(String personName, int location) {
        HttpResponse response;

        try {
            response = Unirest.put("http://localhost:8080/people/" + personName + "/location")
                .body(String.valueOf(location))
                .asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

        assertEquals(200, response.getStatus());
    }

    @Override
    public void shout(String personName, String message) {
        // HTTP GET request to http://localhost:8080/people/personName
        // fill in message box with message
        // Submit form
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        // HTTP GET request to http://localhost:8080/people/personName
        // find all messages on the page
        // return the messages
        return null;
    }
}
