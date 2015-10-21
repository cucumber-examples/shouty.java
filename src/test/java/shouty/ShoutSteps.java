package shouty;

import java.util.Collection;
import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
	Shouty server = new Shouty();

	@Given("^\"(.*?)\" is on Shouty$")
	public void is_on_Shouty(String name) throws Throwable {
		server.getPersonByName(name);
	}

	@When("^\"(.*?)\" sends a shout$")
	public void sends_a_shout(String name) throws Throwable {
		Shout shout = new Shout("Arbitrary contents");
		server.getPersonByName(name).sendShout(shout);
	}

	@Then("^\"(.*?)\" hears the shout$")
	public void hears_the_shout(String name) throws Throwable {
		Collection<Shout> shouts = server.getPersonByName(name).getMyShouts();
		assertEquals(1, shouts.size());
	}

}
