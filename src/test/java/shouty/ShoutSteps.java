package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    Broadcast broadcast;
    Subscriber lucy;
    Subscriber sean;
    String messageThatWasShouted;

    @Given("^Lucy is within range of Sean$")
    public void lucy_is_within_range_of_Sean() throws Throwable {
        broadcast = new Broadcast();
        lucy = new Subscriber(broadcast);
        sean = new Subscriber(broadcast);
    }

    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String message) throws Throwable {
        sean.shout(message);
        messageThatWasShouted = message;
    }

    @Then("^Lucy should hear the shout$")
    public void lucy_should_hear_the_shout() throws Throwable {
        assertEquals(asList(messageThatWasShouted), lucy.getMessagesHeard());
    }


}
