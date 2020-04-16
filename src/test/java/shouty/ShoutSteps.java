package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final ShoutyServiceWrapper shouty = new ShoutyServiceWrapper();

    @Given("nobody has shouted")
    public void noShouts () {}

    @When("Lucy checks the Shouty app")
    public void someoneShouts () {}

    @Then("she should hear nothing")
    public void hearNothing () {
        assertEquals(emptyMap(), shouty.getShouts());
    }

}
