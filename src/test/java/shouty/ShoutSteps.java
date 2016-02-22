package shouty;

import cucumber.api.java.en.*;
import org.junit.Assert;


public class ShoutSteps {
  private final String ARBITRARY_MESSAGE = "Hello, world";
  private final Shouty shouty = new Shouty();


  @Given("^Lucy is at \\[(\\d+), (\\d+)\\]$")
  public void lucy_is_at(int xCoord, int yCoord) throws Throwable {
    shouty.setLocation("Lucy", new Coordinate(xCoord, yCoord));
  }

  @Given("^Sean is at \\[(\\d+), (\\d+)\\]$")
  public void sean_is_at(int xCoord, int yCoord) throws Throwable {
    shouty.setLocation("Sean", new Coordinate(xCoord, yCoord));
  }

  @When("^Sean shouts$")
  public void sean_shouts() throws Throwable {
      shouty.shout("Sean", ARBITRARY_MESSAGE);
  }

  @Then("^Lucy should hear him$")
  public void lucy_should_hear_him() throws Throwable {
      Assert.assertEquals(1, shouty.getMessagesHeardBy("Lucy").size());
  }

  @Then("^Lucy should hear nothing$")
  public void lucy_should_hear_nothing() throws Throwable {
      Assert.assertEquals(0, shouty.getMessagesHeardBy("Lucy").size());
  }
}
