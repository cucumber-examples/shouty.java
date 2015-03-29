package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private Map<String, double[]> places = new HashMap<String, double[]>();
    private Shouty shouty = new Shouty();
    private Person sam;
    private Person lisa;

    @Given("^\"(.+)\" is at (.+),(.+)$")
    public void place_is_at(String placeName, double lat, double lon) throws Throwable {
        places.put(placeName, new double[]{lat, lon});
    }

    @Given("^Sam is in \"(.*?)\"$")
    public void sam_is_in(String placeName) throws Throwable {
        sam = new Person(shouty);
        sam.setLocation(places.get(placeName));
    }

    @Given("^Lisa is in \"(.*?)\"$")
    public void lisa_is_in(String placeName) throws Throwable {
        lisa = new Person(shouty);
        lisa.setLocation(places.get(placeName));
    }

    @When("^Sam shouts \"(.*?)\"$")
    public void sam_shouts(String message) throws Throwable {
        sam.shout(message);
    }

    @Then("^Lisa hears nothing$")
    public void lisa_hears_nothing() throws Throwable {
        List<String> expectedMessages = new ArrayList<String>();
        List<String> actualMessages = lisa.getMessagesHeard();
        assertEquals(expectedMessages, actualMessages);
    }

    @Then("^Lisa hears \"(.*?)\"$")
    public void lisa_hears(String expectedMessage) throws Throwable {
        List<String> expectedMessages = asList(expectedMessage);
        List<String> actualMessages = lisa.getMessagesHeard();
        assertEquals(expectedMessages, actualMessages);
    }
}
