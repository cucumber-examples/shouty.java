package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ShoutSteps {
    private final Shouty shouty = new Shouty();
    private User hiro;
    private User beymax;

    @Given("^Hiro has logged into shouty from (\\d+)ft$")
    public void hiro_has_logged_into_shouty(int position) throws Throwable {
        hiro = new User();
        hiro.login(shouty);
    }
    @Given("^Beymax has logged into shouty from (\\d+)ft$")
    public void beymax_has_logged_into_shouty(int position) throws Throwable {
        beymax = new User();
        beymax.login(shouty);
    }

    @When("^Hiro shouts \"(.*?)\"$")
    public void hiro_shouts(String message) throws Throwable {
        hiro.shout(message);
    }

    @Then("^Beymax should receive the shout \"(.*?)\"$")
    public void beymax_should_receive_the_shout(String expectedMessage) throws Throwable {
        Assert.assertEquals(expectedMessage, beymax.receivedMessages().get(0));
    }

}
