package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
    private final ShoutyDomain shoutyDomain = new ShoutyDomain();

    @Given("^\"(.*?)\" is (\\d+)m from \"(.*?)\"$")
    public void is_m_from(String shouter, long distanceInMeters, String listener) throws Throwable {
        double[] beachBody = new double[]{34.0296612,-118.4587113};
        double[] bestWestern = new double[]{34.0283391,-118.4799290};

        shoutyDomain.personIsIn(shouter, beachBody);
        shoutyDomain.personIsIn(listener, bestWestern);
    }

    @When("^\"(.*?)\" shouts$")
    public void shouts(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\"(.*?)\" can't hear \"(.*?)\"$")
    public void can_t_hear(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }}
