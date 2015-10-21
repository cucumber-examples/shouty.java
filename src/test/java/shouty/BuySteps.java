package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuySteps {

	@Given("^\"(.*?)\" has an account$")
	public void has_an_account(String arg1) throws Throwable {
	}

	@When("^\"(.*?)\" shouts \"(.*?) (\\d+) (.*?)\"$")
	public void shoutsOrder(String name, String orderType, int amount, String rest) throws Throwable {
//		success = system.enterOrder(orderType, amount);
//		assertTrue(success);
	}

	@Then("^\"(.*?)\" gets a confirmation for (\\d+) shares$")
	public void gets_a_confirmation_for_shares(String name, int amount) throws Throwable {
	}

	@Then("^the trading system gets a (buy|sell) order for (\\d+) shares$")
	public void the_trading_system_gets_an_order_for_shares(String orderType, int amount) throws Throwable {
		
	}

	@Then("^\"(.*?)\" gets a error$")
	public void gets_a_error(String arg1) throws Throwable {
	}

	@Then("^the trading system gets nothing$")
	public void the_trading_system_gets_nothing() throws Throwable {
	}
	
	@Then("^Shouty requests a confirmation to buy (\\d+) shares at the market$")
	public void shouty_requests_a_confirmation_to_buy_shares_at_the_market(int arg1) throws Throwable {
	}

	@Then("^Shouty requests a confirmation to sell (\\d+) shares at the market$")
	public void shouty_requests_a_confirmation_to_sell_shares_at_the_market(int arg1) throws Throwable {
	}

	@Then("^Shouty says \"(.*?)\"$")
	public void shouty_says(String arg1) throws Throwable {
	}
}
