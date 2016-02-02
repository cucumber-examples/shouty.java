package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShoutSteps {
	private Shouty shouty;

	@Before
	public void setUp() {
		shouty = new Shouty();
		User.restart();
	}

	@Given("^maximum range is (\\d+) feet$")
	public void maximum_range_is_feet(int distance) throws Throwable {
		shouty.setMaxRange(distance);
	}

	@Given("^(.*) is at location (\\d+)$")
	public void user_is_at_location(String name, int location) throws Throwable {
		shouty.setUserLocation(name, location);
	}

	@When("^(.*) shouts \"(.*?)\"$")
	public void user_shouts(String name, String message) throws Throwable {
		shouty.send(name, message);
	}

	@Then("^(.*) hears nothing$")
	public void user_hears_nothing(String name) throws Throwable {
		assertThat(shouty.getMessagesFor(name), emptyArray());
	}

	@Then("^(.*) hears \"(.*?)\"$")
	public void mary_hears(String name, String message) throws Throwable {
		assertThat(shouty.getMessagesFor(name), arrayContaining(message));
	}
}
