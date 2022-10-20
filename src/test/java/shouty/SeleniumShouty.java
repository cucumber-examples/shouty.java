package shouty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import shouty.web.ShoutyWebServer;

import java.util.ArrayList;
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
        WebDriver browser = findOrCreateBrowser(shouterName);
        browser.get("http://localhost:8090/people/" + shouterName);
        WebElement messageField = browser.findElement(By.id("message"));
        messageField.sendKeys(message);
        messageField.submit();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        WebDriver browser = findOrCreateBrowser(personName);
        browser.get("http://localhost:8090/people/" + personName);
        List<WebElement> messageElements = browser.findElements(By.cssSelector(".messages li"));
        // TODO: Use Java 8 lambdas
        List<String> messages = new ArrayList<>();
        for (WebElement messageElement : messageElements) {
            messages.add(messageElement.getText());
        }
        return messages;
    }

    @Override
    public void stop() {
        for (WebDriver browser : browsers.values()) {
            browser.close();
        }
        try {
            server.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriver findOrCreateBrowser(String personName) {
        WebDriver browser = browsers.get(personName);
        if (browser == null) {
            WebDriverManager.firefoxdriver().setup();
            // Mobile web capabilities
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);

            FirefoxDriver driver = new FirefoxDriver(options);

            browsers.put(personName, browser = driver);
        }
        return browser;
    }

}
