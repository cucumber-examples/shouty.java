package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoutSteps {
    Shouty shouty = new Shouty();

    private Map<String,double[]> LOCATIONS = new HashMap<String, double[]>();

    public static class Location {
        public String locationName;
        public double lat;
        public double lon;
    }

    @Given("^the following locations:$")
    public void theFollowingLocations(List<Location> locations) throws Throwable {
        for (Location location : locations) {
            LOCATIONS.put(location.locationName, new double[]{location.lat, location.lon});
        }
    }

    @Given("^(.+) is in (.+)$")
    public void someoneIsSomewhere(String personName, String locationName) throws Throwable {
        double[] geoLocation = LOCATIONS.get(locationName);
        shouty.personIsIn(personName, geoLocation);
    }

    @When("^Osha shouts \"(.*?)\"$")
    public void oshaShouts(String message) throws Throwable {
        shouty.shout("Osha", message);
    }

    @Then("^Nancy should receive Osha's \"(.*?)\" shout$")
    public void nancyShouldReceiveOshaSShout(String expectedMessage) throws Throwable {
        List<String> actualMessages = shouty.getMessagesHeardBy("Nancy");
        List<String> expectedMessages = Collections.singletonList(expectedMessage);
        assertEquals(expectedMessages, actualMessages);
    }

    @Then("^Nancy should not hear anything$")
    public void nancy_should_not_hear_anything() throws Throwable {
        List<String> actualMessages = shouty.getMessagesHeardBy("Nancy");
        List<String> expectedMessages = new ArrayList<String>();
        assertEquals(expectedMessages, actualMessages);
    }

}


