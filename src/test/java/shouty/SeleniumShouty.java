package shouty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import shouty.web.ShoutyWebServer;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class SeleniumShouty implements Shouty {
    private final WebDriver browser = new FirefoxDriver();
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
        browser.get("http://localhost:8090/people/" + shouterName);
        WebElement messageField = browser.findElement(By.id("message"));
        messageField.sendKeys(message);
        messageField.submit();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        browser.get("http://localhost:8090/people/" + personName);
        List<WebElement> messageElements = browser.findElements(By.cssSelector(".messages li"));
        return messageElements.stream().map(WebElement::getText).collect(toList());
    }
}
