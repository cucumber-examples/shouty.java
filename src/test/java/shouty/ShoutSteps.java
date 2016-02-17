package shouty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
	private final Shopper shopper;
	
	@Autowired
	public ShoutSteps(Shopper shopper) {
		this.shopper = shopper;
	}

	@Given("^a shopping list:$")
	public void i_have_lots_of_data(List<ShoppingListItem> shoppingList) throws Throwable {
		shopper.setShoppingList(shoppingList);
	}
	
	@When("^I go shopping$")
	public void i_go_shopping() throws Throwable {
	}

	@Then("^I should have the following items in my cupboard:$")
	public void i_should_have_the_following_items_in_my_cupboard(DataTable cupboardItems) throws Throwable {
		cupboardItems.diff(shopper.getShoppingList());
	}
}