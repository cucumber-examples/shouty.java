package shouty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import shouty.web.ShoutyWebServer;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class WebShouty implements Shouty {
    private final WebDriver browser = new FirefoxDriver();
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
    public void setLocation(String personName, int locationInMetres) {
        HttpResponse<String> response;

        try {
            response = Unirest.put("http://localhost:8080/people/" + personName + "/location")
                    .body(String.valueOf(locationInMetres))
                    .asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

        assertEquals(200, response.getStatus());
    }

    @Override
    public void shout(String personName, String message) {
        browser.get("http://localhost:8080/people/" + personName);
        WebElement messageField = browser.findElement(By.name("message"));
        messageField.sendKeys(message);
        messageField.submit();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        browser.get("http://localhost:8080/people/" + personName);
        List<WebElement> messageElements = browser.findElements(By.cssSelector(".messages li"));
        return messageElements.stream().map(WebElement::getText).collect(toList());
    }
}
