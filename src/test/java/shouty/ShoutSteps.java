package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucy_is_m_from_Sean(int distanceInMetres) throws Throwable {
        Shouty shouty = new Shouty();
        shouty.setLocation("Lucy", 0);
        shouty.setLocation("Sean", distanceInMetres);
    }

    @When("^Sean shouts$")
    public void sean_shouts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
