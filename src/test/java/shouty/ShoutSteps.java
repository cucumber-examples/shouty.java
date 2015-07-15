package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
    private final Network network = new Network();
    private Person sean;
    private Person lucy;

    @Given("^a person named Lucy is at location (\\d+)$")
    public void lucy_is_at_location(int location) throws Throwable {
        lucy = new Person("Lucy");
        network.register(lucy, location);
    }

    @Given("^a person named Sean is at location (\\d+)$")
    public void sean_is_at_location(int location) throws Throwable {
        sean = new Person("Sean");
        network.register(sean, location);
    }

    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String message) throws Throwable {
        network.broadcast(sean, message);
    }

    @Then("^Lucy hears \"(.*?)\"$")
    public void lucy_hears(String message) throws Throwable {
        if (!lucy.getHeardMessages().contains(message)) {
            throw new Exception("Lucy did not hear the message!");
        }
    }

}
