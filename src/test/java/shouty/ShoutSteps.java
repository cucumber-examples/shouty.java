package shouty;

import cucumber.api.java.en.Given;

public class ShoutSteps {
    private final Shouty shouty = new Shouty();

    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucyIsMFromSean(int distance) throws Throwable {
        shouty.setLocation("Sean", 0);
        shouty.setLocation("Lucy", distance);
    }

}
