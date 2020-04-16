package shouty;

import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private final ShoutyServiceWrapper shouty = new ShoutyServiceWrapper();

    private List<String> shouts;

    @Given("nobody has shouted")
    public void noShouts() {
    }

    @When("Lucy checks the Shouty app")
    public void checkShouts() {
        shouts = shouty.getShouts();
    }

    @Then("she should hear nothing")
    public void hearNothing() {
        assertEquals(emptyList(), shouts);
    }
}
