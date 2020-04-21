package shouty;

import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class ShoutSteps {
    private final ShoutyServiceWrapper shouty;
    private List<Shout> shouts;

    public ShoutSteps(ShoutyServiceWrapper shouty_){
        shouty = shouty_;
    }

    @Given("{word} is at {int}, {int}")
    public void person_is_at(String person, int x, int y) {
        shouty.setLocation(new PersonLocation(person, x, y));
    }

    @When("{word} shouts")
    public void person_shouts(String person) {
        shouty.shout(new Shout(person, "Hello, world"));
    }

    @When("{word} shouts from {int}, {int}")
    public void person_shouts(String person, int x, int y) {
        shouty.shout(new Shout(person, "Hello, world", x, y));
    }

    @Then("{word} should hear {word}")
    public void listener_should_hear_shouter(String listener, String shouter) {
        assertEquals(shouter, shouty.getShouts().get(0).person);
    }

    @Then("{word} should not hear {word}")
    public void listener_should_not_hear_shouter(String listener, String shouter) {
        assertEquals(0, shouty.getShouts().size());
    }
}
