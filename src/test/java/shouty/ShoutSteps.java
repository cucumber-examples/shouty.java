package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private final Shouty shouty = new Shouty();
    private String theMessage;

    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucyIsMFromSean(int distance) throws Throwable {
        shouty.setLocation("Sean", 0);
        shouty.setLocation("Lucy", distance);
    }

    @When("^Sean shouts$")
    public void seanShouts() throws Throwable {
        theMessage = "arbitrary message";
        shouty.shout("Sean", theMessage);
    }

    @Then("^Lucy should hear nothing$")
    public void lucyShouldHearNothing() throws Throwable {
        assertEquals(emptyList(), shouty.getMessagesHeardBy("Lucy"));
    }

    @Then("^Lucy should hear the message$")
    public void lucy_should_hear_the_message() throws Throwable {
        assertEquals(singletonList(theMessage), shouty.getMessagesHeardBy("Lucy"));
    }
}
