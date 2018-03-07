package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    
    @Autowired
    private Shouty shouty;

    @When("^(Lucy|Sean|Oscar) shouts$")
    public void person_shouts(String personName) throws Throwable {
        shouty.shout(personName, ARBITRARY_MESSAGE);
    }

    @Then("^(Lucy|Sean|Oscar) should hear (Lucy|Sean|Oscar)")
    public void listener_should_hear_shouter(String listenerName, String shouterName) throws Throwable {
    		Map<String, List<String>> shoutsHeard = shouty.getShoutsHeardBy(listenerName);
	 	assertTrue(shoutsHeard.containsKey(shouterName));
    }
    
    @Then("^(Lucy|Sean|Oscar) should hear (\\d+) shouts from (Lucy|Sean|Oscar)$")
    public void listener_should_hear_n_shouts_from_shouter(
    	  String listenerName, int numberOfShouts, String shouterName
    	) throws Exception {
    		Map<String, List<String>> shoutsHeard = shouty.getShoutsHeardBy(listenerName);
    		List<String> shoutsByShouter = shoutsHeard.get(shouterName);
    		assertEquals(numberOfShouts, shoutsByShouter.size());
    	}
    
    @Then("^(Lucy|Sean|Oscar) should not hear (Lucy|Sean|Oscar)$")
    public void listener_should_not_hear_shouter(String listenerName, String shouterName) throws Exception {
    	 	Map<String, List<String>> shoutsHeard = shouty.getShoutsHeardBy(listenerName);
    	 	assertFalse(shoutsHeard.containsKey(shouterName));
    }

    @Then("^(Lucy|Sean|Oscar) should hear nothing$")
    public void listener_should_hear_nothing(String listenerName) throws Throwable {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy(listenerName));
    }
}
