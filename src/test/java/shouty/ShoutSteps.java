package shouty;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
	private Shouty network = new Shouty();

	@Given("^\"(.*?)\" is on the network$")
	public void is_on_the_network(String name) throws Throwable {
		network.findPerson(name);
	}

	@When("^\"(.*?)\" shouts \"(.*?)\"$")
	public void shouts(String name, String message) throws Throwable {
		Person person = network.findPerson(name);
		person.shout(message);
	}

	@Then("^\"(.*?)\" hears \"(.*?)\"$")
	public void hears(String name, String message) throws Throwable {
		Person person = network.findPerson(name);
		assertEquals(message, person.getLastMessageHeard());
	}

	@Then("^\"(.*?)\" does not hear a shout$")
	public void does_not_hear_a_shout(String name) throws Throwable {
		Person person = network.findPerson(name);
		assertEquals("", person.getLastMessageHeard());
	}
}
