package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private final ShoutyDomain shoutyDomain = new ShoutyDomain();

    @Given("^\"(.*?)\" is (\\d+)m from \"(.*?)\"$")
    public void is_m_from(String shouter, long distanceInMeters, String listener) throws Throwable {
        double[] beachBody = new double[]{34.0296612,-118.4587113};
        double[] bestWestern = new double[]{34.0283391,-118.4799290};

        shoutyDomain.personIsIn(shouter, beachBody);
        shoutyDomain.personIsIn(listener, bestWestern);
    }

    @When("^\"(.*?)\" shouts$")
    public void shouts(String shouter) throws Throwable {
        shoutyDomain.sendShout(shouter, "hello");
    }

    @Then("^\"(.*?)\" can't hear anything$")
    public void can_t_hear_anything(String listener) throws Throwable {
        List<String> receivedMessages = shoutyDomain.getReceivedMessages(listener);
        assertEquals(new ArrayList<String>(), receivedMessages);
    }}
