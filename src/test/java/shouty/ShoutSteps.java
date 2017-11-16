package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";

    @Autowired
    private Shouty shouty;

    @When("^(\\w+) shouts$")
    public void shouter_shouts(String shouter) throws Throwable {
        shouty.shout(shouter, ARBITRARY_MESSAGE);
    }

    @Then("^(\\w+) should hear Sean")
    public void lucy_should_hear_sean(String listener) throws Throwable {
        Map<String, List<String>> messagesHeard = shouty.getShoutsHeardBy(listener);
        assertTrue(messagesHeard.containsKey("Sean"));
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() throws Throwable {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }

    @Then("^Lucy should not hear Oscar$")
    public void lucy_should_not_hear_oscar() throws Exception {
        Map<String, List<String>> messagesHeard = shouty.getShoutsHeardBy("Lucy");
        assertFalse(messagesHeard.containsKey("Oscar"));
    }

    @Then("^Lucy should hear (\\d+) shouts from Sean$")
    public void lucy_should_hear_shouts_from_sean(int shouts) throws Throwable {
        Map<String, List<String>> messagesHeardBy = shouty.getShoutsHeardBy("Lucy");
        List<String> messagesHeard = messagesHeardBy.get("Sean");
        assertEquals(shouts, messagesHeard.size());
    }
}
