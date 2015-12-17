package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

public class ShoutSteps {

    Person tom;
    Person fred;
    Shouty app = new Shouty();

    @Given("^Fred is at location \\((\\d+),(\\d+)\\)$")
    public void fred_is_at_location(int lat, int lng) throws Throwable {
        Location location = new Location(lat, lng);
        fred = new Person(location);
        app.register(fred);
    }

    @Given("^Tom is at location \\((\\d+),(\\d+)\\)$")
    public void tom_is_at_location(int lat, int lng) throws Throwable {
        Location location = new Location(lat, lng);
        tom = new Person(location);
        app.register(tom);
    }

    @When("^Tom shouts \"(.*?)\"$")
    public void tom_shouts(String message) throws Throwable {
        app.broadcast(message, tom);
    }

    @Then("^Fred hears \"(.*?)\"$")
    public void fred_hears(String expectedMessage) throws Throwable {
        ArrayList<String> messages = fred.messagesHeard();
        Assert.that(messages.contains(expectedMessage), "Fred did not hear the message.");
    }

    @Then("^Fred does not hear \"([^\"]*)\"$")
    public void Fred_does_not_hear(String expectedMessage) throws Throwable {
        ArrayList<String> messages = fred.messagesHeard();
        Assert.that(!messages.contains(expectedMessage), "Fred heard the message but he shouldn't have.");
    }
}
