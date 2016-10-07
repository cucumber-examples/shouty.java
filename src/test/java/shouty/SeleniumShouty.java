package shouty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SeleniumShouty implements ShoutyApi {
    private final Map<String, WebDriver> browsers = new HashMap<String, WebDriver>();
    private final int port;

    public SeleniumShouty(int port) {
        this.port = port;
    }

    @Override
    public void setLocation(String personName, int locationInMetres) {
        HttpRequestWithBody post = Unirest.post(url("/people/" + personName + "/move"));
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
        WebDriver browser = findOrCreateBrowser(shouterName);
        browser.get(url("/people/" + shouterName));
        WebElement messageField = browser.findElement(By.id("message"));
        messageField.sendKeys(message);
        messageField.submit();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        WebDriver browser = findOrCreateBrowser(personName);
        browser.get(url("/people/" + personName));
        List<WebElement> messageElements = browser.findElements(By.cssSelector(".messages li"));
        // TODO: Use Java 8 lambdas
        List<String> messages = new ArrayList<>();
        for (WebElement messageElement : messageElements) {
            messages.add(messageElement.getText());
        }
        return messages;
    }

    private String url(String path) {
        return "http://localhost:" + port + path;
    }

    public void stop() {
        for (WebDriver browser : browsers.values()) {
            browser.close();
        }
    }

    private WebDriver findOrCreateBrowser(String personName) {
        WebDriver browser = browsers.get(personName);
        if (browser == null) {
            browsers.put(personName, browser = new FirefoxDriver());
        }
        return browser;
    }

}
