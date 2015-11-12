package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
    Network network;
    Person richard;
    Person chloe;

    @Given("^Chloe is within (\\d+)m of Richard$")
    public void chloe_is_within_m_of_Richard(int distance) throws Throwable {
        chloe = new Person(0,0);
        richard = new Person(0,0);
        network = new Network();
        network.register(chloe);
        network.register(richard);
    }

    @When("^Richard shouts \"(.*?)\"$")
    public void richard_shouts(String message) throws Throwable {
        richard.shout(message, network);
    }

    @Then("^Chloe hears \"(.*?)\"$")
    public void chloe_hears(String expectedMessage) throws Throwable {
        if (!chloe.messagesHeard().contains(expectedMessage)) {
            throw new Exception("Chloe did not hear the message!");
        }
    }
}
