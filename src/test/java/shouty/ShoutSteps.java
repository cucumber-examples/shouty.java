package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private final ShoutyDomain shoutyDomain = new ShoutyDomain();

    @Given("^\"(.*?)\" is (\\d+)m from \"(.*?)\"$")
    public void is_m_from(String shouter, long distanceInMeters, String listener) throws Throwable {
        double[] beachBody = new double[]{34.0296612, -118.4587113};
        double[] bestWestern = new double[]{34.0283391, -118.4799290};
        double[] lemonMoon = new double[]{34.0296612, -118.4578852};

        shoutyDomain.personIsIn(shouter, beachBody);

        if (distanceInMeters < 1000) {
            shoutyDomain.personIsIn(listener, lemonMoon);
        } else {
            shoutyDomain.personIsIn(listener, bestWestern);
        }
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
