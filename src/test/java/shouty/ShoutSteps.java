package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {

    private final Shouty shouty = new DomainShouty();

    @Given("^Linda is (\\d+)m away from Fred$")
    public void linda_is_m_away_from_Fred(int distanceInMetres) throws Throwable {
        shouty.setLocation("Linda", 0);
        shouty.setLocation("Fred", distanceInMetres);
    }

    @When("^Fred shouts$")
    public void fred_shouts() throws Throwable {
        shouty.shout("Fred", "Free bagels!");
    }

    @Then("^Linda should hear nothing$")
    public void linda_should_hear_nothing() throws Throwable {
        List<String> messages = shouty.getMessagesHeardBy("Linda");
        assertEquals(emptyList(), messages);
    }

    @Then("^Linda should hear Fred’s shout$")
    public void lindaShouldHearFredSShout() throws Throwable {
        List<String> messages = shouty.getMessagesHeardBy("Linda");
        assertEquals(singletonList("Free bagels!"), messages);
    }
}
