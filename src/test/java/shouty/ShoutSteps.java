package shouty;

import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private final ShoutyServiceWrapper shouty = new ShoutyServiceWrapper();

    private List<Shout> shouts;

    @Before("@API_1.0.0")
    public void useAPI_100() {
        shouty.setAPI("1.0.0");
    }

    @Before("@API_1.1.0")
    public void useAPI_110() {
        shouty.setAPI("1.1.0");
    }

    @Given("nobody has shouted")
    public void no_shouts() {
    }

    @Given("somebody has shouted")
    public void somebody_has_shouted() {
        shouty.shout(new Shout("???", "???"));
    }

    @Given("somebody has shouted {string}")
    public void somebody_has_shouted(String message) {
        shouty.shout(new Shout("???", message));
    }

    @Given("Sean has shouted")
    public void sean_has_shouted() {
        shouty.shout(new Shout("Sean", "???"));
    }

    @When("Lucy checks the Shouty app")
    public void checkShouts() {
        shouts = shouty.getShouts();
    }

    @Then("she should hear nothing")
    public void hearNothing() {
        assertEquals(emptyList(), shouts);
    }

    @Then("she should hear {int} shout")
    public void she_should_hear_some_shouts(int shout_count) {
        assertEquals(shout_count, shouts.size());
    }

    @Then("she should hear {string}")
    public void she_should_hear(String message) {
        assertEquals(message, shouts.get(0).message);
    }

    @Then("she should hear a shout from Sean")
    public void she_should_hear_a_shout_from_Sean() {
        assertEquals("Sean", shouts.get(0).person);
    }
}
