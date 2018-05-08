package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("^(Lucy|Sean|Oscar) is at (\\d+), (\\d+)$")
    public void lucy_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

    @Given("^people are located at$")
    public void peopleAreLocatedAt(List<PersonLocation> personLocations) throws Exception {
        for (int index = 0; index < personLocations.size(); index++) {
            PersonLocation pl = personLocations.get(index);
            shouty.setLocation(pl.name, new Coordinate(pl.x, pl.y));
        }
    }

    @When("^(Sean|Oscar|Lucy) shouts$")
    public void sean_shouts(String name) {
        shouty.shout(name, ARBITRARY_MESSAGE);
    }

    @Then("^Lucy should hear Sean")
    public void lucy_should_hear_sean() {
        Map<String, List<String>> shoutsHeard = shouty.getShoutsHeardBy("Lucy");
        List<String> seansShouts = shoutsHeard.get("Sean");
        assertEquals(1, seansShouts.size());
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }

    @Then("^Lucy should not hear Oscar$")
    public void lucyShouldNotHearOscar() {
        Map<String, List<String>> shoutsHeard = shouty.getShoutsHeardBy("Lucy");
        assertFalse("Lucy should not hear Oscar", shoutsHeard.containsKey("Oscar"));
    }
}
