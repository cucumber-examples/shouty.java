package shouty;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shouty.web.ShoutySoapServer;
import shouty.web.ShoutyWebServer;
import shouty.web.ShoutyWebService;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShoutSteps {

    private final ShoutyApi shoutyApi;
    private final ShoutyServer shoutyServer;

    public ShoutSteps() throws Exception {
        if ("selenium".equals(System.getProperty("automation"))) {
            int port = 8090;
            shoutyApi = new SeleniumShouty(port);
            shoutyServer = new ShoutyWebServer(port, new DomainShouty());
        } else if ("soap".equals(System.getProperty("automation"))) {
            int port = 8091;
            Endpoint endpoint = Endpoint.create(new ShoutyWebService(new DomainShouty()));
            String baseUrl = "http://localhost:" + port + "/ws/shouty";
            endpoint.publish(baseUrl);

            shoutyApi = new SoapShouty(baseUrl);
            shoutyServer = new ShoutySoapServer(endpoint);
        } else {
            shoutyApi = new DomainShouty();
            shoutyServer = new NullServer();
        }
    }

    @Before
    public void startServer() {
        shoutyServer.start();
    }

    @After
    public void stopServer() {
        shoutyServer.stop();
        if (shoutyApi instanceof SeleniumShouty) {
            ((SeleniumShouty) shoutyApi).stop();
        }
    }

    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucy_is_m_from_Sean(int distanceInMetres) throws Throwable {
        shoutyApi.setLocation("Lucy", 0);
        shoutyApi.setLocation("Sean", distanceInMetres);
    }

    @When("^Sean shouts$")
    public void sean_shouts() throws Throwable {
        shoutyApi.shout("Sean", "Free bagels!");
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() throws Throwable {
        assertEquals(new ArrayList(), shoutyApi.getMessagesHeardBy("Lucy"));
    }

    @Then("^Lucy should hear Sean's shout$")
    public void lucy_should_hear_Sean_s_shout() throws Throwable {
        assertEquals(Arrays.asList("Free bagels!"), shoutyApi.getMessagesHeardBy(("Lucy")));
    }
}
