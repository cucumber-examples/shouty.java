package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {

    private final Shouty shouty = new Shouty();

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
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
