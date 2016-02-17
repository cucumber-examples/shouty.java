package shouty;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
	private List<ShoppingListItem> shoppingList;

	@Given("^a shopping list:$")
	public void i_have_lots_of_data(List<ShoppingListItem> shoppingList) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		this.shoppingList = shoppingList;
	}
	
	@When("^I go shopping$")
	public void i_go_shopping() throws Throwable {
	}

	@Then("^I should have the following items in my cupboard:$")
	public void i_should_have_the_following_items_in_my_cupboard(DataTable cupboardItems) throws Throwable {
		cupboardItems.diff(shoppingList);
	}
	
	public static class ShoppingListItem {
		public String item;
		public int amount;
	}
}