package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private final ShoutyDomain shoutyDomain = new ShoutyDomain();
    private Map<String,double[]> geoLocations = new HashMap<String, double[]>() {{
        put("BeachBody HQ", new double[]{34.0296612, -118.4587113});
        put("Best Western", new double[]{34.0283391, -118.4799290});
        put("Lemon Moon", new double[]{34.0296612, -118.4578852});
    }};

    @Given("^\"(.*?)\" is in \"(.*?)\"$")
    public void is_in(String personName, String locationName) throws Throwable {
        double[] geoLocation = geoLocations.get(locationName);
        shoutyDomain.personIsIn(personName, geoLocation);
    }

    @When("^\"(.*?)\" shouts$")
    public void shouts(String shouter) throws Throwable {
        shoutyDomain.sendShout(shouter, "hello");
    }

    @When("^\"(.*?)\" shouts \"(.*?)\"$")
    public void shouts(String shouter, String message) throws Throwable {
        shoutyDomain.sendShout(shouter, message);
    }

    @Then("^\"(.*?)\" can't hear anything$")
    public void can_t_hear_anything(String listener) throws Throwable {
        List<String> receivedMessages = shoutyDomain.getReceivedMessages(listener);
        assertEquals(new ArrayList<String>(), receivedMessages);
    }

    @Then("^\"(.*?)\" can hear \"(.*?)\"$")
    public void can_hear(String listener, String expectedMessage) throws Throwable {
        List<String> receivedMessages = shoutyDomain.getReceivedMessages(listener);
        assertEquals(Collections.singletonList(expectedMessage), receivedMessages);
    }
}
