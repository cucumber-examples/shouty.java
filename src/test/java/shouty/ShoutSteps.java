package shouty;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShoutSteps {
    Shouty network = new Shouty();
    Person linda = network.getPerson("Linda");
    Person shawn = network.getPerson("Shawn");


    @When("^(.*) shouts \"(.*)\"$")
    public void shawn_shouts(String name, String shout) throws Throwable {
        shawn.shout(shout);
    }

    @Then("^Linda hears nothing$")
    public void linda_hears_nothing() throws Throwable {
        assertTrue(linda.getReceivedMessages().isEmpty());
    }

    @Then("^Linda hears \"(.*?)\"$")
    public void linda_hears(String shout) throws Throwable {
        assertFalse("Linda should hear "+shout, linda.getReceivedMessages().isEmpty());
    }
}
