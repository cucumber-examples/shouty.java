package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static java.util.Collections.emptyMap;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("^(\\w+) is at (\\d+), (\\d+)$")
    public void lucy_is_at(String person, int xCoord, int yCoord) throws Throwable {
        shouty.setLocation(person, new Coordinate(xCoord, yCoord));
    }

    @When("^(\\w+) shouts$")
    public void shouter_shouts(String shouter) throws Throwable {
        shouty.shout(shouter, ARBITRARY_MESSAGE);
    }

    @Then("^(\\w+) should hear Sean")
    public void lucy_should_hear_sean(String listener) throws Throwable {
        Map<String, String> messagesHeard = shouty.getShoutHeardBy(listener);
        assertTrue(messagesHeard.containsKey("Sean"));
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() throws Throwable {
        assertEquals(emptyMap(), shouty.getShoutHeardBy("Lucy"));
    }

    @Then("^Lucy should not hear Oscar$")
    public void lucy_should_not_hear_oscar() throws Exception {
        Map<String, String> messagesHeard = shouty.getShoutHeardBy("Lucy");
        assertFalse(messagesHeard.containsKey("Oscar"));
    }

}
