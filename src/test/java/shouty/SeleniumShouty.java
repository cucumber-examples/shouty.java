package shouty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import shouty.web.ShoutyWebServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SeleniumShouty implements Shouty {
    private final Map<String, WebDriver> browsers = new HashMap<String, WebDriver>();
    private final ShoutyWebServer server;

    public SeleniumShouty() throws Exception {
        server = new ShoutyWebServer(8090);
        server.start();
    }

    @Override
    public void setLocation(String personName, int locationInMetres) {
        HttpRequestWithBody post = Unirest.post("http://localhost:8090/people/" + personName + "/move");
        post.body(String.valueOf(locationInMetres));
        try {
            HttpResponse<String> response = post.asString();
            assertEquals(201, response.getStatus());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shout(String shouterName, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        throw new UnsupportedOperationException();
    }

    private WebDriver findOrCreateBrowser(String personName) {
        WebDriver browser = browsers.get(personName);
        if (browser == null) {
            browsers.put(personName, browser = new FirefoxDriver());
        }
        return browser;
    }

}
