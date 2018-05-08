package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("^(Lucy|Sean) is at (\\d+), (\\d+)$")
    public void lucy_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

    @When("^Sean shouts$")
    public void sean_shouts() {
        shouty.shout("Sean", ARBITRARY_MESSAGE);
    }

    @Then("^Lucy should hear Sean")
    public void lucy_should_hear_sean() {
        assertEquals(1, shouty.getShoutsHeardBy("Lucy").size());
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }
}
