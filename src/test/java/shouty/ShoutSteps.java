package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private final Shouty shouty = new Shouty();

    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucyIsMFromSean(int distance) throws Throwable {
        shouty.setLocation("Sean", 0);
        shouty.setLocation("Lucy", distance);
    }

    @When("^Sean shouts$")
    public void seanShouts() throws Throwable {
        shouty.shout("Sean", "arbitrary message");
    }

    @Then("^Lucy should hear nothing$")
    public void lucyShouldHearNothing() throws Throwable {
        assertEquals(emptyList(), shouty.getMessagesHeardBy("Lucy"));
    }
}
